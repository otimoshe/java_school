package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.PassengerDao;
import com.tsystems.railway.entity.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PassengerDaoImpl implements PassengerDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addPassenger(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(passenger);
    }

    @Override
    public void deletePassenger(int id) {
        Session session = sessionFactory.getCurrentSession();
        Passenger passenger = this.getPassengerById(id);
        if (passenger != null){
            session.delete(passenger);
        }
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.update(passenger);
    }

    @Override
    public Passenger getPassengerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Passenger passenger = ( Passenger) session.load(Passenger.class,id);
        return passenger;
    }

    @Override
    public List<Passenger> getAllPassenger() {
        Session session = sessionFactory.getCurrentSession();
        List<Passenger>  passengers = session.createQuery("from Passenger").list();
        return passengers;
    }
}
