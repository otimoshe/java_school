package com.tsystems.railway.DTO;

import java.math.BigDecimal;
import java.sql.Date;

public class TicketDTO {
    private long id;
    private PassengerDTO passenger;
    private TripDTO trip;
    private StationDTO departureStation;
    private StationDTO arrivalStation;
    private Date departureDate;
    private Date arrivalDate;
    private SeatDTO seat;
    private BigDecimal price;

    public TicketDTO(long id, PassengerDTO passenger, TripDTO trip, StationDTO departureStation, StationDTO arrivalStation, Date departureDate, Date arrivalDate, SeatDTO seat, BigDecimal price) {
        this.id = id;
        this.passenger = passenger;
        this.trip = trip;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.seat = seat;
        this.price = price;
    }

    public TicketDTO() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PassengerDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDTO passenger) {
        this.passenger = passenger;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }

    public StationDTO getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(StationDTO departureStation) {
        this.departureStation = departureStation;
    }

    public StationDTO getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(StationDTO arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public SeatDTO getSeat() {
        return seat;
    }

    public void setSeat(SeatDTO seat) {
        this.seat = seat;
    }
}
