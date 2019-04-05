package com.tsystems.railway.DTO;

// TODO delete????
import java.sql.Time;

public class TemplateStationDTO {
    private TimeTemplateDTO templateDTO;
    private StationDTO stationDTO;
    private Time arrivalTime;
    private Time departureTime;

    public TemplateStationDTO() {
    }

    public TemplateStationDTO(TimeTemplateDTO templateDTO, StationDTO stationDTO, Time arrivalTime, Time departureTime) {
        this.templateDTO = templateDTO;
        this.stationDTO = stationDTO;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public TimeTemplateDTO getTemplateDTO() {
        return templateDTO;
    }

    public void setTemplateDTO(TimeTemplateDTO templateDTO) {
        this.templateDTO = templateDTO;
    }

    public StationDTO getStationDTO() {
        return stationDTO;
    }

    public void setStationDTO(StationDTO stationDTO) {
        this.stationDTO = stationDTO;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }
}
