package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.entity.Route;

import java.util.List;

public interface RouteMapper {

    Route dtoToEntity(RouteDTO routeDTO);

    RouteDTO entityToDto(Route route);

    List<RouteDTO> listEntityToDtoList(List<Route> routeList);

    List<Route> listDtoToEntityList(List<RouteDTO> dtoList);
}
