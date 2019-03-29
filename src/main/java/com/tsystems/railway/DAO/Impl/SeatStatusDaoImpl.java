package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.SeatStatusDao;
import com.tsystems.railway.entity.SeatStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class SeatStatusDaoImpl implements SeatStatusDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override

    public void addSeatStatus(SeatStatus seatStatus) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(seatStatus);
    }

    @Override
    public void deleteSeatStatus(int id) {
        Session session = sessionFactory.getCurrentSession();
        SeatStatus seatStatus =this.getSeatStatusById(id);
        if (seatStatus != null){
            session.delete(seatStatus);
        }
    }

    @Override
    public void updateSeatStatus(SeatStatus seatStatus) {
        Session session = sessionFactory.getCurrentSession();
        session.update(seatStatus);
    }

    @Override
    public List<SeatStatus> getSeatStatusesForSeat(int seatId) {
        Session session = sessionFactory.getCurrentSession();
        List<SeatStatus> seatStatuses = session.createQuery("from SeatStatus where seat_id="+seatId).list();
        return  seatStatuses;
    }

    @Override
    public SeatStatus getSeatStatusById(int id) {
        Session session = sessionFactory.getCurrentSession();
        SeatStatus seatStatus = (SeatStatus) session.load(SeatStatus.class,id);
        return seatStatus;
    }
}
