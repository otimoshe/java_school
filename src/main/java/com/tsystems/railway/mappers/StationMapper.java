package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.entity.Station;

import java.util.List;

public interface StationMapper {
    Station dtoToEntity(StationDTO stationDTO);

    StationDTO entityToDto(Station station);

    List<StationDTO> listEntityToDtoList(List<Station > stationList);

    List<Station> listDtoToEntityList(List<StationDTO> dtoList);
}
