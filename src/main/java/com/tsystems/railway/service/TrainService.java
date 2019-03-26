package com.tsystems.railway.service;

import com.tsystems.railway.DTO.TrainDTO;
import com.tsystems.railway.entity.Train;

import java.util.List;

public interface TrainService {

     void addTrain(Train train);

     void updateTtain(Train train);

     void removeTrain(int id);

     Train getTrainById(int id);

     TrainDTO getTrainDtoById(int id);

     List<Train> listTrains();

    List<TrainDTO> listTrainDTOs();
}
