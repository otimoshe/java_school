package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.*;
import com.tsystems.railway.entity.*;
import com.tsystems.railway.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketMapperImpl implements TicketMapper {

    @Autowired
    PassengerMapper passengerMapper;

    @Autowired
    StationMapper stationMapper;

    @Autowired
    TripMapper tripMapper;

    @Autowired
    SeatMapper seatMapper;

    @Override
    public Ticket dtoToEntity(TicketDTO ticketDTO) {
        int id = ticketDTO.getId();
        Passenger passenger = passengerMapper.dtoToEntity(ticketDTO.getPassenger());
        Station departureStation = stationMapper.dtoToEntity(ticketDTO.getDepartureStation());
        Station arrivalStation = stationMapper.dtoToEntity(ticketDTO.getArrivalStation());
        Date departureDate = ticketDTO.getDepartureDate();
        Date arrivalDate = ticketDTO.getArrivalDate();
        Trip trip = tripMapper.dtoToEntity(ticketDTO.getTrip());
        Seat seat = seatMapper.dtoToEntity(ticketDTO.getSeat());
        BigDecimal price = ticketDTO.getPrice();
        Time departTime = ticketDTO.getDepartTime();
        Time arriveTime= ticketDTO.getArrivalTime();
        return new Ticket(id,passenger,trip,departureStation,arrivalStation,departureDate,arrivalDate,seat,price,departTime,arriveTime);
    }

    @Override
    public TicketDTO entityToDto(Ticket ticket) {
        int id = ticket.getId();
        PassengerDTO passengerDTO = passengerMapper.entityToDto(ticket.getPassenger());
        StationDTO departureStation = stationMapper.entityToDto(ticket.getDepartureStation());
        StationDTO arrivalStation = stationMapper.entityToDto(ticket.getArrivalStation());
        Date departureDate = ticket.getDepartureDate();
        Date arrivalDate = ticket.getArrivalDate();
        TripDTO tripDTO = tripMapper.entityToDto(ticket.getTrip());
        SeatDTO seatDTO = seatMapper.entityToDto(ticket.getSeat());
        BigDecimal price = ticket.getPrice();
        Time departTime = ticket.getDepartureTime();
        Time arriveTime = ticket.getArrivalTime();

        return new TicketDTO(id,passengerDTO, tripDTO,departureStation,arrivalStation,departureDate,arrivalDate,seatDTO,price,departTime,arriveTime);
    }

    @Override
    public List<TicketDTO> listEntityToDtoList(List<Ticket> tickets) {
        List<TicketDTO> dtoList =new ArrayList<>();
        for (Ticket ticket:tickets){
            dtoList.add(this.entityToDto(ticket));
        }
        return dtoList;
    }

    @Override
    public List<Ticket> listDtoToEntityList(List<TicketDTO> dtoList) {
        List<Ticket> passengers = new ArrayList<>();
        for (TicketDTO dto:dtoList){
            passengers.add(this.dtoToEntity(dto));
        }
        return passengers;
    }
}
