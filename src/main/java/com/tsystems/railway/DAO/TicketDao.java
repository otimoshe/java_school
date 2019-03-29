package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Ticket;

import java.util.List;

public interface TicketDao {
    void addTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
    void deleteTicket(int id);
    Ticket getTicketById(int id);
    List<Ticket> getTicketsForTrip(int tripId);

}
