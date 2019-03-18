package com.tsystems.railway.dao;

import com.tsystems.railway.model.Station;
import com.tsystems.railway.model.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class StationDaoImpl implements StationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addStation(Station station) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(station);
    }

    @Override
    public Station getStationById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Station station = (Station) session.load(Station.class,id);
        return station;
    }

    @Override
    public void deleteStation(long id) {
        Session session = sessionFactory.getCurrentSession();
        Station station = this.getStationById(id);
        if (station != null){
            session.delete(station);
        }

    }

    @Override
    public void updateStation(Station station) {
        Session session = sessionFactory.getCurrentSession();
        session.update(station);
    }

    @Override
    public List<Station> listStations() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Station> stationList = session.createQuery("from Station").list();
        return stationList;
    }
}