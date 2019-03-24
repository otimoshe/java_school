package com.tsystems.railway.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name ="schedule")
public class Schedule {

    @Id
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
    private Station currentStation;

    @ManyToOne
    @JoinColumn(name = "next_station_id")
    private Station nextStation;

    @ManyToOne
    @JoinColumn(name = "previous_station_id")
    private Station prevStation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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



    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
            //    ", train=" + train +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
             //   ", currentStation=" + currentStation +
            //    ", nextStation=" + nextStation +
            //    ", prevStation=" + prevStation +
                '}';
    }
}
