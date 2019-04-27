package com.tsystems.railway.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    @Column(name = "ticket_id")
    private long id;

    @OneToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @JoinColumn (name = "departure_station_id")
    private Station departureStation;

    @ManyToOne
    @JoinColumn(name = "arrival_station_id")
    private Station arrivalStation;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "arrival_time")
    private Time arrivalTime;

    @Column(name = "departure_time")
    private Time departureTime;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "seat_id")
    Seat seat;

    @Column(name = "price")
    private BigDecimal price;




    public Ticket() {
    }

    public Ticket(long id, Passenger passenger, Trip trip, Station departureStation, Station arrivalStation, Date departureDate, Date arrivalDate, Seat seat, BigDecimal price) {
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

    public Ticket(long id,Passenger passenger, Trip trip, Station departureStation, Station arrivalStation, Date departureDate, Date arrivalDate, Time arrivalTime, Time departureTime, Seat seat, BigDecimal price) {
        this.id = id;
        this.passenger = passenger;
        this.trip = trip;
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.seat = seat;
        this.price = price;
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

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
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
}
