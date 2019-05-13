package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.TicketDao;
import com.tsystems.railway.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class TicketDaoImpl  implements TicketDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addTicket(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        Session session = sessionFactory.getCurrentSession();
        session.update(ticket);
    }

    @Override
    public void deleteTicket(int id) {
        Session session = sessionFactory.getCurrentSession();
        Ticket ticket = this.getTicketById(id);
        if (ticket != null){
            session.delete(ticket);
        }
    }

    @Override
    public Ticket getTicketById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Ticket ticket =(Ticket) session.load(Ticket.class,id);
        return ticket;
    }

    @Override
    public List<Ticket> getTicketsForTrip(int tripId) {
        Session session = sessionFactory.getCurrentSession();
        List <Ticket> tickets = session.createQuery("from Ticket where trip_id="+tripId).list();
        return tickets;
    }
}
