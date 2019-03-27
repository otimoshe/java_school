package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.DTO.TrainDTO;
import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.mappers.TrainMapper;
import com.tsystems.railway.mappers.TripMapper;
import com.tsystems.railway.entity.Route;
import com.tsystems.railway.entity.Train;
import com.tsystems.railway.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;


@Component
public class TripMapperImpl implements TripMapper {

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private TrainMapper trainMapper;

    @Override
    public Trip dtoToEntity(TripDTO dto) {
        int id = dto.getId();
        Route route = routeMapper.dtoToEntity(dto.getRoute());
        Date date =  dto.getDepartureDate();
        Train train = trainMapper.dtoToEntity(dto.getTrain());
        //TODO add after_insert triiger for creation schedules for this trip
        return new Trip (id,route,date,train);
    }

    @Override
    public TripDTO entityToDto(Trip trip) {
        int id = trip.getId();
        RouteDTO route = routeMapper.entityToDto(trip.getRoute());
        Date date = trip.getDeparture_date();
        TrainDTO trainDTO = trainMapper.entityToDto( trip.getTrain());
        return new TripDTO(id,route,date,trainDTO);
    }

    @Override
    public List<TripDTO> listEntityToDtoList(List<Trip> tripList) {
        List<TripDTO> dtoList = new ArrayList<>();
        for ( Trip trip:tripList){
            dtoList.add(this.entityToDto(trip));
        }

        return dtoList;
    }

    @Override
    public List<Trip> listDtoToEntityList(List<TripDTO> dtoList) {
        List<Trip> tripList = new ArrayList<>();

        for(TripDTO dto:dtoList){
            tripList.add(this.dtoToEntity(dto));
        }

        return tripList;
    }
}
