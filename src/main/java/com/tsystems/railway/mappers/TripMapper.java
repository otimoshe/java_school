package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.model.Route;
import com.tsystems.railway.model.Trip;

import java.util.List;

public interface TripMapper  {

    Trip dtoToEntity(TripDTO dto);

    TripDTO entityToDto(Trip trip);

    List<TripDTO> listEntityToDtoList(List<Trip> tripList);

    List<Trip> listDtoToEntityList(List<TripDTO> dtoList);

}
