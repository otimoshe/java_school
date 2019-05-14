package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.TicketDao;
import com.tsystems.railway.DTO.*;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.mappers.TicketMapper;
import com.tsystems.railway.service.PassengerService;
import com.tsystems.railway.service.SeatService;
import com.tsystems.railway.service.TicketService;
import com.tsystems.railway.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketDao ticketDao;

    @Autowired
    TicketMapper ticketMapper;

    @Autowired
    SeatService seatService;

    @Autowired
    RouteMapper routeMapper;

    @Autowired
    TripService tripService;

    @Autowired
    PassengerService passengerService;


    @Override
    public void addTicket(TicketDTO ticket) {
        ticketDao.addTicket(ticketMapper.dtoToEntity(ticket));
    }

    @Override
    public void updateTicket(TicketDTO ticket) {
        ticketDao.updateTicket(ticketMapper.dtoToEntity(ticket));
    }

    @Override
    public void deleteTicket(int id) {
        TicketDTO ticket = this.getTicketById(id);
        SeatDTO seat = ticket.getSeat();
        Map<StationDTO,Boolean> statuses =  seat.getStatuses();
        StationDTO departStation =  ticket.getDepartureStation();
        StationDTO arriveStation = ticket.getArrivalStation();
        List<StationDTO> stations =  ticket.getTrip().getRoute().getStationList();
        List<StationDTO> subRoute = stations.subList(stations.indexOf(departStation),stations.indexOf(arriveStation));
        subRoute.add(arriveStation);
        for (StationDTO stationDTO: subRoute){
            statuses.put(stationDTO,true);
        }
        seat.setStatuses(statuses);
        seatService.updateSeat(seat);
        ticketDao.deleteTicket(id);
    }

    @Override
    public List<TicketDTO> getTicketsForTrip(int tripId) {
       return ticketMapper.listEntityToDtoList(ticketDao.getTicketsForTrip(tripId));
    }

    public TicketDTO getTicketById(int id){
      return  ticketMapper.entityToDto(ticketDao.getTicketById(id));
    }

    @Override
    public void buyTicket(TicketForm form) {
        TripDTO trip = tripService.getTripById(form.getTripId());
        PassengerDTO passenger = passengerService.getPassengerById(form.getPassengerId());
        StationDTO departStation = tripService.getStationbyId(form.getDepartStationId());
        StationDTO arriveStation = tripService.getStationbyId(form.getArriveStationId());
        SeatDTO seat = seatService.getSeatById(form.getSeatId());
        BigDecimal price = form.getPrice();
        Date departDate = form.getDepartureDate();
        Date arriveDate = form.getArriveDate();
        Time departTime = form.getDepartureTime();
        Time arriveTime = form.getArriveTime();
        // change seatstatus for seat
        Map<StationDTO,Boolean> statuses =  seat.getStatuses();
        List<StationDTO> stations =  trip.getRoute().getStationList();
        List<StationDTO> subRoute = stations.subList(stations.indexOf(departStation),stations.indexOf(arriveStation));
        for (StationDTO stationDTO: subRoute){
            statuses.put(stationDTO,false);
        }
        seat.setStatuses(statuses);
        seatService.updateSeat(seat);
        TicketDTO ticket = new TicketDTO(passenger,trip,departStation,arriveStation,departDate,arriveDate,departTime,arriveTime,seat,price);
        this.addTicket(ticket);
    }
}
