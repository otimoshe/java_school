package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.PassengerDTO;
import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.entity.Passenger;
import com.tsystems.railway.entity.Route;

import java.util.List;

public interface PassengerMapper {

    Passenger dtoToEntity(PassengerDTO passengerDTO);

    PassengerDTO entityToDto(Passenger passenger);

    List<PassengerDTO> listEntityToDtoList(List<Passenger> passengers);

    List<Passenger> listDtoToEntityList(List<PassengerDTO> dtoList);
}
