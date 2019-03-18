package com.tsystems.railway.service;

import com.tsystems.railway.model.Train;

import java.util.List;

public interface TrainService {

    public void addTrain(Train train);

    public void updateTtain(Train train);

    public void removeTrain(long id);

    public Train getTrainById(long id);

    public List<Train> listTrains();
}
