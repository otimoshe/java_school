package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.SeatDao;
import com.tsystems.railway.entity.Seat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class SeatDaoImpl implements SeatDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override

    public void addSeat(Seat seat) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(seat);
    }

    @Override
    public void updateSeat(Seat seat) {
        Session session = sessionFactory.getCurrentSession();
        session.update(seat);
    }

    @Override
    public void deleteSeat(int id) {
        Session session = sessionFactory.getCurrentSession();
        Seat seat = this.getSeatById(id);
        if (seat != null) {
            session.delete(seat);
        }
    }

    @Override
    public List<Seat> listSeatsForTrip(int tripId) {
        Session session = sessionFactory.getCurrentSession();
        List<Seat> seats = session.createQuery("from Seat where trip_id=" + tripId).list();
        return seats;
    }

    @Override
    public Seat getSeatById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Seat seat = (Seat) session.load(Seat.class, id);
        return seat;
    }


}
