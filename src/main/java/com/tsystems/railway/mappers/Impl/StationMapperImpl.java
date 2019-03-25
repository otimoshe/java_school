package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.model.Station;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StationMapperImpl implements StationMapper {

    public Station dtoToEntity(StationDTO stationDTO){
        int id = stationDTO.getId();
        String name = stationDTO.getName();
        return new Station(id,name);
    }

    public StationDTO entityToDto(Station station){
       int id = station.getId();
       String name = station.getName();
        return new StationDTO(id,name);
    }

    @Override
    public List<StationDTO> listEntityToDtoList(List<Station> stationList) {
        List<StationDTO> dtoList = new ArrayList<>();
        for (Station station: stationList){
            dtoList.add(this.entityToDto(station));
        }
        return dtoList;
    }

    @Override
    public List<Station> listDtoToEntityList(List<StationDTO> dtoList) {
        List<Station> stationList = new ArrayList<>();
        for(StationDTO dto:dtoList){
            stationList.add(this.dtoToEntity(dto));
        }
        return stationList;
    }
}
