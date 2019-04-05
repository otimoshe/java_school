package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.SeatDTO;
import com.tsystems.railway.DTO.TemplateStationDTO;
import com.tsystems.railway.entity.Seat;
import com.tsystems.railway.entity.TemplateStation;

import java.util.List;
import java.util.Set;

public interface TemplateStationMapper {

    TemplateStation dtoToEntity(TemplateStationDTO templateStationDTO);

    TemplateStationDTO entityToDto(TemplateStation templateStation);

    List<TemplateStationDTO> listEntityToDtoList(List<TemplateStation> templateStations);

    List<TemplateStation> listDtoToEntityList(List<TemplateStationDTO> dtoList);

    Set<TemplateStation> setDtoToEntitySet(Set<TemplateStationDTO> dtoSet);

    Set<TemplateStationDTO> setEntityToDtoSet(Set<TemplateStation> entitySet);
}
