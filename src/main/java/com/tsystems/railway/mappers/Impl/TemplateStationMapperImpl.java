package com.tsystems.railway.mappers.Impl;


import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.DTO.TemplateStationDTO;
import com.tsystems.railway.DTO.TimeTemplateDTO;
import com.tsystems.railway.entity.Station;
import com.tsystems.railway.entity.TemplateStation;
import com.tsystems.railway.entity.TimeTemplate;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.mappers.TemplateStationMapper;
import com.tsystems.railway.mappers.TimeTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TemplateStationMapperImpl implements TemplateStationMapper {

    @Autowired
    TimeTemplateMapper timeTemplateMapper;

    @Autowired
    StationMapper stationMapper;

    @Override
    public TemplateStation dtoToEntity(TemplateStationDTO templateStationDTO) {
        TimeTemplate timeTemplate = timeTemplateMapper.dtoToEntity(templateStationDTO.getTemplateDTO());
        Station station = stationMapper.dtoToEntity(templateStationDTO.getStationDTO());
        Time arrivalTime = templateStationDTO.getArrivalTime();
        Time departureTime = templateStationDTO.getDepartureTime();

        return new TemplateStation(timeTemplate,station,arrivalTime,departureTime);
    }

    @Override
    public TemplateStationDTO entityToDto(TemplateStation templateStation) {
        TimeTemplateDTO timeTemplateDTO = timeTemplateMapper.entityToDto(templateStation.getTemplate());
        StationDTO stationDTO = stationMapper.entityToDto(templateStation.getStation());
        Time arrivalTime = templateStation.getArrivalTime();
        Time departureTime = templateStation.getDepartureTime();

        return new TemplateStationDTO(timeTemplateDTO,stationDTO,arrivalTime,departureTime);
    }

    @Override
    public List<TemplateStationDTO> listEntityToDtoList(List<TemplateStation> templateStations) {
        List<TemplateStationDTO> dtoList = new ArrayList<>();
        for (TemplateStation templateStation:templateStations){
            dtoList.add(this.entityToDto(templateStation));
        }
        return dtoList;
    }

    @Override
    public List<TemplateStation> listDtoToEntityList(List<TemplateStationDTO> dtoList) {
        List<TemplateStation> entityList = new ArrayList<>();
        for(TemplateStationDTO dto:dtoList){
            entityList.add(this.dtoToEntity(dto));
        }
        return entityList;
    }

    @Override
    public Set<TemplateStation> setDtoToEntitySet(Set<TemplateStationDTO> dtoSet) {
        Set<TemplateStation> entitySet = new HashSet<>();
        for(TemplateStationDTO dto:dtoSet){
            entitySet.add(this.dtoToEntity(dto));
        }
        return entitySet;
    }

    @Override
    public Set<TemplateStationDTO> setEntityToDtoSet(Set<TemplateStation> entitySet) {
        Set<TemplateStationDTO> dtoSet = new HashSet<>();
        for (TemplateStation templateStation:entitySet){
            dtoSet.add(this.entityToDto(templateStation));
        }
        return dtoSet;
    }
}
