package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.StationDao;
import com.tsystems.railway.entity.Station;
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
    public Station getStationById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Station station = (Station) session.load(Station.class,id);
        return station;
    }

    @Override
    public void deleteStation(int id) {
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

    @Override
    public Station getStationByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        Station station = (Station) session.load(Station.class,name);
        return station;
    }
}
