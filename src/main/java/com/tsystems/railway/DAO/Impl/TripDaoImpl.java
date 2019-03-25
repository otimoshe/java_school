package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.TripDao;
import com.tsystems.railway.model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class TripDaoImpl implements TripDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addtrip(Trip trip) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(trip);
    }

    @Override
    public void deleteTrip(int id) {
        Session session = sessionFactory.getCurrentSession();
        Trip trip = this.getTripById(id);
        if (trip != null){
            session.delete(trip);
        }
    }

    @Override
    public void updateTrip(Trip trip) {
        Session session = sessionFactory.getCurrentSession();
        session.update(trip);
    }

    @Override
    public Trip getTripById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Trip trip = (Trip) session.load(Trip.class,id);
        return trip;
    }

    @Override
    public List<Trip> listTrips() {
        Session session = sessionFactory.getCurrentSession();
        List<Trip> trips = session.createQuery("from Trip").list();
        return trips;
    }
}
