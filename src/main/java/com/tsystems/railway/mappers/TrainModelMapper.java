package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.TrainDTO;
import com.tsystems.railway.DTO.TrainModelDTO;
import com.tsystems.railway.model.Train;
import com.tsystems.railway.model.TrainModel;

import java.util.List;

public interface TrainModelMapper {

    TrainModel dtoToEntity(TrainModelDTO trainDTO);

    TrainModelDTO entityToDto(TrainModel trainModel);

    List<TrainModelDTO> listEntityToDtoList(List<TrainModel> trainModelList);

    List<TrainModel> listDtoToEntityList(List<TrainModelDTO> dtoList);
}
