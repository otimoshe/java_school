package com.tsystems.railway.DTO;

import java.util.HashMap;

public class SeatDTO {
    private int id;
    private TripDTO tripDto;
    private HashMap<StationDTO, Boolean> statuses;

    public SeatDTO(int id, TripDTO tripDto, HashMap<StationDTO, Boolean> statuses) {
        this.id = id;
        this.tripDto = tripDto;
        this.statuses = statuses;
    }

    public SeatDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TripDTO getTripDto() {
        return tripDto;
    }

    public void setTripDto(TripDTO tripDto) {
        this.tripDto = tripDto;
    }

    public HashMap<StationDTO, Boolean> getStatuses() {
        return statuses;
    }

    public void setStatuses(HashMap<StationDTO, Boolean> statuses) {
        this.statuses = statuses;
    }
}
