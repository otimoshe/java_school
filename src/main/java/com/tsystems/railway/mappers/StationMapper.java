package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.model.Station;

public interface StationMapper {
    Station dtoToEntity(StationDTO stationDTO);

    StationDTO entityToDto(Station station);
}
