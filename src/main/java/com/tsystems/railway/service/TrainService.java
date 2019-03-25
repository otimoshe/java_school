package com.tsystems.railway.service;

import com.tsystems.railway.DTO.TrainDTO;
import com.tsystems.railway.model.Train;

import java.util.List;

public interface TrainService {

     void addTrain(Train train);

     void updateTtain(Train train);

     void removeTrain(long id);

     Train getTrainById(long id);

     List<Train> listTrains();

    List<TrainDTO> listTrainDTOs();
}
