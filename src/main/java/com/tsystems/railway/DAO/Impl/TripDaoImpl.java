package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.TripDao;
import com.tsystems.railway.entity.Schedule;
import com.tsystems.railway.entity.Trip;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
public class TripDaoImpl implements TripDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override

    public void addtrip(Trip trip) {
        Session session = sessionFactory.getCurrentSession();
        session.save(trip);
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

    @Override
    public List<Trip> getTripListWithIds(List<Integer> tripsId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Trip where trip_id in (:ids)");
        query.setParameterList("ids", tripsId);
        List<Trip> trips = query.list();
        return trips;
    }

    @Override
    public List<Trip> listTripsInDay(Date date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Trip  WHERE departure_date = '"+ date+"'");
        List<Trip> trips = query.list();
        return trips;
    }
}
