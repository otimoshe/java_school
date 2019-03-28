package com.tsystems.railway.mappers.Impl;



import com.tsystems.railway.DTO.PassengerDTO;
import com.tsystems.railway.entity.Passenger;
import com.tsystems.railway.mappers.PassengerMapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PassengerMapperImpl  implements PassengerMapper {

    @Override
    public Passenger dtoToEntity(PassengerDTO passengerDTO) {
       int id = passengerDTO.getId();
       String name = passengerDTO.getName();
       String lastName = passengerDTO.getLastName();
       Date birthday = passengerDTO.getBirthday();

        return new Passenger(id,name,lastName,birthday);
    }

    @Override
    public PassengerDTO entityToDto(Passenger passenger) {
        int id = passenger.getId();
        String name = passenger.getName();
        String lastName = passenger.getLastName();
        Date birthday = passenger.getBirhtDate();
        return new PassengerDTO(id,name,lastName,birthday);
    }

    @Override
    public List<PassengerDTO> listEntityToDtoList(List<Passenger> passengers) {
        List<PassengerDTO> dtos = new ArrayList<>();
        for( Passenger passenger:passengers){
            dtos.add(this.entityToDto(passenger));
        }
        return dtos;
    }

    @Override
    public List<Passenger> listDtoToEntityList(List<PassengerDTO> dtoList) {
        List<Passenger> passengers = new ArrayList<>();
        for(PassengerDTO dto:dtoList){
            passengers.add(this.dtoToEntity(dto));
        }
        return  passengers;
    }
}
