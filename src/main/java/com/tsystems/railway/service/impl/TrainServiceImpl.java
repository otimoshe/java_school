package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.TrainDao;
import com.tsystems.railway.DTO.TrainDTO;
import com.tsystems.railway.mappers.TrainMapper;
import com.tsystems.railway.model.Train;
import com.tsystems.railway.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service

public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainDao trainDao;

    @Autowired
    private TrainMapper trainMapper;

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

    @Override
    public List<TrainDTO> listTrainDTOs() {
        return this.trainMapper.listEntityToDtoList(this.listTrains());
    }
}
