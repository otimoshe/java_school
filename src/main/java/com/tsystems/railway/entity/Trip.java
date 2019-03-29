package com.tsystems.railway.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @Column(name = "trip_id")
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @Column(name = "departure_date")
    private Date departure_date;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    @OneToMany(mappedBy = "trip")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Set<Schedule> schedules;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.REMOVE)
    private Set<Seat> seats;

    @OneToMany(mappedBy = "trip")
    private Set<Ticket>tickets;

    public Trip(int id,Route route, Date departure_date, Train train) {
        this.id = id;
        this.route = route;
        this.departure_date = departure_date;
        this.train = train;
    }

    public Trip(Route route, Date departure_date, Train train) {
        this.route = route;
        this.departure_date = departure_date;
        this.train = train;
    }

    public Trip() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}
