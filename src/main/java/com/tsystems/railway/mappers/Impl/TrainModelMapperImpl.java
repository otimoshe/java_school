package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.TrainModelDTO;
import com.tsystems.railway.mappers.TrainModelMapper;
import com.tsystems.railway.model.TrainModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainModelMapperImpl implements TrainModelMapper {
    @Override
    public TrainModel dtoToEntity(TrainModelDTO trainDTO) {
        String name = trainDTO.getName();
        return new TrainModel(name);
    }

    @Override
    public TrainModelDTO entityToDto(TrainModel trainModel) {
        int id = trainModel.getId();
        String name = trainModel.getName();
        return new TrainModelDTO(id,name);
    }

    @Override
    public List<TrainModelDTO> listEntityToDtoList(List<TrainModel> trainModelList) {
        List<TrainModelDTO> dtoList = new ArrayList<>();
        for (TrainModel trainModel:trainModelList){
            dtoList.add(this.entityToDto(trainModel));
        }
        return dtoList;
    }

    @Override
    public List<TrainModel> listDtoToEntityList(List<TrainModelDTO> dtoList) {
        List<TrainModel> trainModelList = new ArrayList<>();
        for (TrainModelDTO dto:dtoList){
            trainModelList.add(this.dtoToEntity(dto));
        }
        return trainModelList;
    }
}
