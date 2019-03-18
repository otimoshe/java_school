package com.tsystems.railway.service;

import com.tsystems.railway.dao.TrainDao;
import com.tsystems.railway.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao trainDao;

    public void setTrainDao(TrainDao trainDao) {
        this.trainDao = trainDao;
    }

    @Override

    public void addTrain(Train train) {
        this.trainDao.addTrain(train);
    }

    @Override

    public void updateTtain(Train train) {
        this.trainDao.updateTtain(train);
    }

    @Override

    public void removeTrain(long id) {
        this.trainDao.removeTrain(id);
    }

    @Override

    public Train getTrainById(long id) {
        return this.trainDao.getTrainById(id);
    }

    @Override

    public List<Train> listTrains() {
        return this.trainDao.listTrains();
    }
}
