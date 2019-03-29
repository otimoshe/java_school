package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.TicketDao;
import com.tsystems.railway.DTO.TicketDTO;
import com.tsystems.railway.mappers.TicketMapper;
import com.tsystems.railway.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketDao ticketDao;

    @Autowired
    TicketMapper ticketMapper;

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
        ticketDao.deleteTicket(id);
    }

    @Override
    public List<TicketDTO> getTicketsForTrip(int tripId) {
       return ticketMapper.listEntityToDtoList(ticketDao.getTicketsForTrip(tripId));

    }
}
