package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.TrainModel;

import java.util.List;

public interface TrainModelDao {

    public void addTrainModel(TrainModel trainModel);

    public void updateTrainModel(TrainModel trainModel);

    public void removeTrainModel(int id);

    public TrainModel getTrainModelById(int id);

    public List<TrainModel> listTrainModel();
}
