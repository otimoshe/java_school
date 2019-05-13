package com.tsystems.railway.DTO;
import java.util.LinkedHashMap;
import java.util.Map;


public class SeatDTO {
    private int id;
    private TripDTO tripDto;
    private int number;
    private Map<StationDTO, Boolean> statuses;

    public SeatDTO(int id, TripDTO tripDto, int number, LinkedHashMap<StationDTO, Boolean> statuses) {
        this.id = id;
        this.tripDto = tripDto;
        this.number = number;
        this.statuses = statuses;
    }

    public SeatDTO(TripDTO tripDto, int number, LinkedHashMap<StationDTO, Boolean> statuses) {
        this.tripDto = tripDto;
        this.number = number;
        this.statuses = statuses;
    }

    public SeatDTO() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public Map<StationDTO, Boolean> getStatuses() {
        return statuses;
    }

    public void setStatuses(Map<StationDTO, Boolean> statuses) {
        this.statuses = statuses;
    }
}
