package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.SeatDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.DTO.TripDTO;
import com.tsystems.railway.entity.Seat;
import com.tsystems.railway.entity.SeatStatus;
import com.tsystems.railway.entity.Trip;
import com.tsystems.railway.mappers.SeatMapper;
import com.tsystems.railway.mappers.TripMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SeatMapperImpl implements SeatMapper {

    @Autowired
    TripMapper tripMapper;

    @Autowired
    StationMapperImpl stationMapper;

    @Override
    public Seat dtoToEntity(SeatDTO seatDTO) {
        Seat seat = new Seat();
        seat.setId(seatDTO.getId());
        seat.setTrip(tripMapper.dtoToEntity(seatDTO.getTripDto()));
        Map<StationDTO, Boolean> statuses = seatDTO.getStatuses();
        seat.setNumber(seatDTO.getNumber());
        HashSet<SeatStatus> seatStatuses = new HashSet<>();
        for (Map.Entry<StationDTO, Boolean> entry : statuses.entrySet()) {
            seatStatuses.add(new SeatStatus(seat, stationMapper.dtoToEntity(entry.getKey()), entry.getValue()));
        }
        seat.setSeatStatuses(seatStatuses);
        return seat;
    }

    @Override
    public SeatDTO entityToDto(Seat seat) {
        int id = seat.getId();
        TripDTO trip = tripMapper.entityToDto(seat.getTrip());
        LinkedHashMap<StationDTO, Boolean> statuses = new LinkedHashMap<>();
        Set<SeatStatus> seatStatuses = seat.getSeatStatuses();
        int number = seat.getNumber();
        for (SeatStatus status : seatStatuses) {
            statuses.put(stationMapper.entityToDto(status.getStation()), status.isAvailable());
        }

        return new SeatDTO(id,trip,number, statuses);

    }

    @Override
    public List<SeatDTO> listEntityToDtoList(List<Seat> seats) {
        List<SeatDTO> dtoList = new ArrayList<>();
        for (Seat seat : seats) {
            dtoList.add(this.entityToDto(seat));
        }
        return dtoList;
    }

    @Override
    public List<Seat> listDtoToEntityList(List<SeatDTO> dtoList) {
        List<Seat> seats = new ArrayList<>();
        for (SeatDTO dto : dtoList) {
            seats.add(this.dtoToEntity(dto));
        }
        return seats;
    }
}
