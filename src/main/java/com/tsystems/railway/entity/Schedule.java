package com.tsystems.railway.entity;


import javax.persistence.*;
import java.sql.Date;

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

    @Column(name = "departure_date")
    private Date departureDate;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;




    public Schedule() {

    }

    public Schedule(long id, Trip trip, Date arrivalDate, Date departureDate, Station currentStation) {
        this.id = id;
        this.trip = trip;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.station = currentStation;
       ;
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


}
