package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.model.Route;
import com.tsystems.railway.model.Train;
import com.tsystems.railway.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class TripMapperImpl implements TripMapper {

    @Autowired
    RouteMapper routeMapper;

    @Autowired
    Tra

    @Override
    public Trip dtoToEntity(TripDTO dto) {
        Route route = routeMapper.dtoToEntity(dto.getRoute());
        Date date =  dto.getDepartureDate();
        Train train = dto.getTrain();

        return null;
    }

    @Override
    public TripDTO entityToDto(Trip trip) {
        return null;
    }

    @Override
    public List<TripDTO> listEntityToDtoList(List<Trip> tripList) {
        return null;
    }

    @Override
    public List<Trip> listDtoToEntityList(List<TripDTO> dtoList) {
        return null;
    }
}
