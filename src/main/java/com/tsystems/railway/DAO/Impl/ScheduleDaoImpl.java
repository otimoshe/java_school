package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.ScheduleDao;
import com.tsystems.railway.entity.Schedule;
import com.tsystems.railway.entity.Trip;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TemporalType;
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addSchedule(Schedule schedule) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(schedule);
    }

    @Override
    public void deleteSchedule(long id) {
        Session session= sessionFactory.getCurrentSession();
        Schedule schedule = this.getScheduleById(id);
        if (schedule != null){
            session.delete(schedule);
        }
    }

    @Override
    public Schedule getScheduleById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Schedule schedule = (Schedule) session.load(Schedule.class,id);
        return schedule;
    }

    @Override
    public void updateSchedule(Schedule schedule) {
        Session session= sessionFactory.getCurrentSession();
        session.update(schedule);
    }

    @Override
    public List<Schedule> getAllSchedule() {
        Session session = sessionFactory.getCurrentSession();
        List<Schedule> schedules = session.createQuery("from Schedule").list();
        return schedules;
    }

    @Override
    public List<Schedule> getSchedulesForTrip(int tripId) {
        Session session = sessionFactory.getCurrentSession();
        List<Schedule> schedules = session.createQuery("from Schedule where trip_id ="+tripId).list();
        return schedules;
    }

    @Override
    public List<Schedule> getSchedulesForStation(int stationId, Date date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Schedule where station_id = "+stationId+" and (departureDate = '"+ date +"' or arrivalDate = '"+ date +"' )" );
        //query.setParameter("date",new java.sql.Timestamp(date.getTime()));
        //java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        List<Schedule> schedules = query.list();
        return schedules;
    }
}
