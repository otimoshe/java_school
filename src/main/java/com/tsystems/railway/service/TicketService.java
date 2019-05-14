package com.tsystems.railway.service;

import com.tsystems.railway.DTO.TicketDTO;
import com.tsystems.railway.DTO.TicketForm;
import com.tsystems.railway.entity.Ticket;

import java.util.List;

public interface TicketService {

    void addTicket(TicketDTO ticket);

    void updateTicket(TicketDTO ticket);

    void deleteTicket(int id);

    List<TicketDTO> getTicketsForTrip(int tripId);

    void buyTicket(TicketForm form);

}
