package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.SeatDTO;
import com.tsystems.railway.DTO.TemplateStationDTO;
import com.tsystems.railway.DTO.TimeTemplateDTO;
import com.tsystems.railway.entity.TemplateStation;
import com.tsystems.railway.entity.TimeTemplate;

import java.util.List;

public interface TimeTemplateMapper {

    TimeTemplate dtoToEntity(TimeTemplateDTO timeTemplateDTO);

    TimeTemplateDTO entityToDto(TimeTemplate timeTemplate);

    List<TimeTemplateDTO> listEntityToDtoList(List<TimeTemplate> timeTemplateList);

    List<TimeTemplate> listDtoToEntityList(List<TimeTemplateDTO> dtoList);
}
