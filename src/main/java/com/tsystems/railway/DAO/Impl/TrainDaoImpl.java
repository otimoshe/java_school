package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.TrainDao;
import com.tsystems.railway.model.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class TrainDaoImpl implements TrainDao {

   @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTrain(Train train) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(train);
    }

    @Override
    public void updateTtain(Train train) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(train);
    }

    @Override
    public void removeTrain(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Train train = (Train) session.load(Train.class,id);

        if(train != null){
            session.delete(train);
        }
    }

    @Override
    public Train getTrainById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Train train = (Train) session.load(Train.class,id);
        return train;
    }

    @Override
    public List<Train> listTrains() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Train> trainList = session.createQuery("from Train").list();
        return trainList;
    }
}
