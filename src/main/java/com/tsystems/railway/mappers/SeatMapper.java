package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.ScheduleDTO;
import com.tsystems.railway.DTO.SeatDTO;
import com.tsystems.railway.entity.Schedule;
import com.tsystems.railway.entity.Seat;

import java.util.List;

public interface SeatMapper {

    Seat dtoToEntity(SeatDTO seatDTO);

    SeatDTO entityToDto(Seat seat);

    List<SeatDTO> listEntityToDtoList(List<Seat> seats);

    List<Seat> listDtoToEntityList(List<SeatDTO> dtoList);
}
