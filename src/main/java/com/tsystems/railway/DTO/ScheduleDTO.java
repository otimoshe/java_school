package com.tsystems.railway.DTO;

import java.sql.Date;

public class ScheduleDTO {

    private long id;
    private TripDTO trip;
    private Date arrivalDate;
    private Date departureDate;
    private StationDTO station;


    public ScheduleDTO() {

    }

    public ScheduleDTO(long id, TripDTO trip, Date arrivalDate, Date departureDate, StationDTO station) {
        this.id = id;
        this.trip = trip;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.station = station;

    }

    public ScheduleDTO(TripDTO trip, Date arrivalDate, Date departureDate, StationDTO station) {
        this.trip = trip;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.station = station;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public StationDTO getStation() {
        return station;
    }

    public void setStation(StationDTO station) {
        this.station = station;
    }


}
