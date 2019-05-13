package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.TicketDao;
import com.tsystems.railway.DTO.SeatDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.DTO.TicketDTO;
import com.tsystems.railway.entity.Seat;
import com.tsystems.railway.entity.SeatStatus;
import com.tsystems.railway.entity.Station;
import com.tsystems.railway.entity.Ticket;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.mappers.TicketMapper;
import com.tsystems.railway.service.SeatService;
import com.tsystems.railway.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
}
