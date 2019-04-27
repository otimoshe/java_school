package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.TrainDTO;
import com.tsystems.railway.DTO.TrainModelDTO;
import com.tsystems.railway.mappers.TrainMapper;
import com.tsystems.railway.mappers.TrainModelMapper;
import com.tsystems.railway.entity.Train;
import com.tsystems.railway.entity.TrainModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class TrainMapperImpl implements TrainMapper {

    @Autowired
    TrainModelMapper trainModelMapper;

    @Override
    public Train dtoToEntity(TrainDTO trainDTO) {
        int id = trainDTO.getId();
        TrainModel trainModel = trainModelMapper.dtoToEntity(trainDTO.getTrainModelDTO());
        int numberOfSeats = trainDTO.getNumberOfSeats();
        return new Train(id,numberOfSeats, trainModel);
    }

    @Override
    public TrainDTO entityToDto(Train train) {
       int id = train.getId();
       TrainModelDTO trainModelDTO = trainModelMapper.entityToDto(train.getTrainModel());
       int numberOfSeats = train.getNumberOfSeats();
        return new TrainDTO(id,numberOfSeats,trainModelDTO);
    }

    @Override
    public List<TrainDTO> listEntityToDtoList(List<Train> trainList) {
        List<TrainDTO> dtoList = new ArrayList<>();
        for (Train train:trainList){
            dtoList.add(this.entityToDto(train));
        }
        return dtoList;
    }

    @Override
    public List<Train> listDtoToEntityList(List<TrainDTO> dtoList) {
        List<Train> trainList = new ArrayList<>();
        for (TrainDTO dto:dtoList){
            trainList.add(this.dtoToEntity(dto));
        }
        return trainList;
    }
}
