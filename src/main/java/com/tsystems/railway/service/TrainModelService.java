package com.tsystems.railway.service;

import com.tsystems.railway.model.Train;
import com.tsystems.railway.model.TrainModel;

import java.util.List;

public interface TrainModelService {

    public void addTrainModel(TrainModel trainModel);

    public void updateTrainModel(TrainModel trainModel);

    public void removeTrainModel(int id);

    public TrainModel getTrainModelById(int id);

    public List<TrainModel> listTrainModels();
}
