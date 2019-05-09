package com.tsystems.railway.service;

import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.DTO.TicketDTO;
import com.tsystems.railway.DTO.TripDTO;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Service
public interface BuyTicketService {
    List<TripDTO> findRelevantTrips(String departureStationName,String arrivalStationName, Date date);
    TicketDTO buyTicket();
    Set<StationDTO> getAvailableStationForStation(int stationId);

}
