package com.tsystems.railway.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name ="schedule")
public class Schedule {

    @Id
    @GeneratedValue
    @Column(name = "schedule_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "date_of_arrival")
    private Date arrivalDate;

    @Column(name = "departure_date", columnDefinition = "DATE")
    private Date departureDate;

    @Column(name= "departure_time")
    private Time departureTime;

    @Column(name = "arrival_time")
    private Time arrivalTime;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;




    public Schedule() {

    }

    public Schedule(long id, Trip trip, Date arrivalDate, Date departureDate, Station currentStation, Time arrivalTime, Time departureTime) {
        this.id = id;
        this.trip = trip;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.station = currentStation;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
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

    public Station getStation() {
        return station;
    }

    public void setStation(Station currentStation) {
        this.station = currentStation;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
