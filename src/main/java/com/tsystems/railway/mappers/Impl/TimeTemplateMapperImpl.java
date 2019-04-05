package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.DTO.TemplateStationDTO;
import com.tsystems.railway.DTO.TimeTemplateDTO;
import com.tsystems.railway.entity.Route;
import com.tsystems.railway.entity.SeatStatus;
import com.tsystems.railway.entity.TemplateStation;
import com.tsystems.railway.entity.TimeTemplate;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.mappers.TemplateStationMapper;
import com.tsystems.railway.mappers.TimeTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.*;

@Component
public class TimeTemplateMapperImpl implements TimeTemplateMapper {

    @Autowired
    RouteMapper routeMapper;

    @Autowired
    StationMapper stationMapper;

    @Override
    public TimeTemplate dtoToEntity(TimeTemplateDTO timeTemplateDTO) {
        TimeTemplate result = new TimeTemplate();
        int id = timeTemplateDTO.getId();
        String name = timeTemplateDTO.getName();
        Route route = routeMapper.dtoToEntity(timeTemplateDTO.getRoute());
        Set<TemplateStation> templateSet =  new HashSet<>();

        for (Map.Entry<StationDTO, List<Time>> entry : timeTemplateDTO.getTemplateStation().entrySet()) {
            Time arrivalTime = entry.getValue().get(0);
            Time departuretime = entry.getValue().get(1);
            templateSet.add(new TemplateStation(result, stationMapper.dtoToEntity(entry.getKey()),arrivalTime,departuretime));
        }

        result.setId(id);
        result.setName(name);
        result.setRoute(route);
        result.setTemplateStationSet(templateSet);

        return result ;
    }

    @Override
    public TimeTemplateDTO entityToDto(TimeTemplate timeTemplate) {
        int id = timeTemplate.getId();
        String name = timeTemplate.getName();
        RouteDTO routeDTO = routeMapper.entityToDto(timeTemplate.getRoute());
        HashMap<StationDTO,List<Time>> templateStationMap = new HashMap<>();

        for(TemplateStation template:timeTemplate.getTemplateStationSet()){
            List<Time> times = new ArrayList<>();
            times.add(template.getArrivalTime());
            times.add(template.getDepartureTime());
            templateStationMap.put(stationMapper.entityToDto(template.getStation()),times);
        }
        return new TimeTemplateDTO(id,name,routeDTO,templateStationMap);
    }

    @Override
    public List<TimeTemplateDTO> listEntityToDtoList(List<TimeTemplate> timeTemplateList) {
        List<TimeTemplateDTO> dtoList = new ArrayList<>();
        for(TimeTemplate entity:timeTemplateList){
            dtoList.add(this.entityToDto(entity));
        }
        return dtoList;
    }

    @Override
    public List<TimeTemplate> listDtoToEntityList(List<TimeTemplateDTO> dtoList) {
        List<TimeTemplate> entityList = new ArrayList<>();
        for(TimeTemplateDTO dto:dtoList){
            entityList.add(this.dtoToEntity(dto));
        }
        return entityList;
    }
}
