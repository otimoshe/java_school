package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.TrainModelDao;
import com.tsystems.railway.entity.TrainModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository

public class TrainModelDaoImpl implements TrainModelDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTrainModel(TrainModel trainModel) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(trainModel);
    }

    @Override
    public void updateTrainModel(TrainModel trainModel) {
        Session session = sessionFactory.getCurrentSession();
        session.update(trainModel);
    }

    @Override
    public void removeTrainModel(int id) {
        Session session = sessionFactory.getCurrentSession();
        TrainModel trainModel = (TrainModel) session.load(TrainModel.class,id);
        if(trainModel != null){
            session.delete(trainModel);
        }
    }

    @Override
    public TrainModel getTrainModelById(int id) {
        Session session = sessionFactory.getCurrentSession();
        TrainModel trainModel = (TrainModel) session.load(TrainModel.class,id);
        return trainModel;
    }

    @Override
    public List<TrainModel> listTrainModel() {
        Session session = this.sessionFactory.getCurrentSession();
        List<TrainModel> trainModelList = session.createQuery("from TrainModel").list();
        System.out.println(trainModelList.size());
        return trainModelList;
    }
}
