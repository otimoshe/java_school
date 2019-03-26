package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.TrainDTO;
import com.tsystems.railway.entity.Train;

import java.util.List;

public interface TrainMapper {

    Train dtoToEntity(TrainDTO trainDTO);

    TrainDTO entityToDto(Train train);

    List<TrainDTO> listEntityToDtoList(List<Train> trainList);

    List<Train> listDtoToEntityList(List<TrainDTO> dtoList);
}
