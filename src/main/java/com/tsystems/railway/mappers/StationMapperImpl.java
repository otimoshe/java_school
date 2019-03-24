package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.model.Station;
import org.springframework.stereotype.Component;

@Component
public class StationMapperImpl implements  StationMapper{

    public Station dtoToEntity(StationDTO stationDTO){ return null;}
    public StationDTO entityToDto(Station station){return null;}
}
