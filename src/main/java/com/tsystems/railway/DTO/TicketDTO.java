package com.tsystems.railway.DTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class TicketDTO {
    private int id;
    private PassengerDTO passenger;
    private TripDTO trip;
    private StationDTO departureStation;
    private StationDTO arrivalStation;
    private Date departureDate;
    private Date arrivalDate;
    private Time arrivalTime;
    private Time departTime;
    private SeatDTO seat;
    private BigDecimal price;

    public TicketDTO(int id, PassengerDTO passenger, TripDTO trip, StationDTO departureStation, StationDTO arrivalStation, Date departureDate, Date arrivalDate, SeatDTO seat, BigDecimal price) {
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

    public TicketDTO(PassengerDTO passenger, TripDTO trip, StationDTO departureStation, StationDTO arrivalStation, Date departureDate, Date arrivalDate, SeatDTO seat, BigDecimal price) {
        this.passenger = passenger;
        this.trip = trip;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.seat = seat;
        this.price = price;
    }

    public TicketDTO(PassengerDTO passenger, TripDTO trip, StationDTO departureStation, StationDTO arrivalStation, Date departureDate, Date arrivalDate, Time arrivalTime, Time departTime, SeatDTO seat, BigDecimal price) {
        this.passenger = passenger;
        this.trip = trip;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departTime = departTime;
        this.seat = seat;
        this.price = price;
    }

    public TicketDTO(int id, PassengerDTO passengerDTO, TripDTO tripDTO, StationDTO departureStation, StationDTO arrivalStation, Date departureDate, Date arrivalDate,
                     SeatDTO seatDTO, BigDecimal price, Time departTime, Time arriveTime) {
        this.id = id;
        this.passenger = passengerDTO;
        this.trip = tripDTO;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arriveTime;
        this.departTime = departTime;
        this.seat = seatDTO;
        this.price = price;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Time departTime) {
        this.departTime = departTime;
    }

    public TicketDTO() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
