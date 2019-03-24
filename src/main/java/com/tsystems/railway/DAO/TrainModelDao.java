package com.tsystems.railway.DAO;

import com.tsystems.railway.model.TrainModel;

import java.util.List;

public interface TrainModelDao {

    public void addTrainModel(TrainModel trainModel);

    public void updateTtainModel(TrainModel trainModel);

    public void removeTrainModel(int id);

    public TrainModel getTrainModelById(int id);

    public List<TrainModel> listTrainModel();
}
