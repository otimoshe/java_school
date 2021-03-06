package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.TrainModelDao;
import com.tsystems.railway.entity.TrainModel;
import com.tsystems.railway.service.TrainModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrainModelServiceImpl implements TrainModelService {

    @Autowired
    private TrainModelDao trainModelDao;

    @Override
    public void addTrainModel(TrainModel trainModel) {
        trainModelDao.addTrainModel(trainModel);
    }

    @Override
    public void updateTrainModel(TrainModel trainModel) {
        trainModelDao.updateTrainModel(trainModel);
    }

    @Override
    public void removeTrainModel(int id) {
        trainModelDao.removeTrainModel(id);
    }

    @Override
    public TrainModel getTrainModelById(int id) {
         return trainModelDao.getTrainModelById(id);
    }

    @Override
    public List<TrainModel> listTrainModels() {
        return trainModelDao.listTrainModel();
    }
}
