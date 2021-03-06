package com.tsystems.railway.entity;

import javax.persistence.*;
import java.sql.Date;
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

    @OneToMany(mappedBy = "trip",cascade = CascadeType.ALL)
    private Set<Schedule> schedules;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private Set<Seat> seats;

    @OneToMany(mappedBy = "trip",cascade = CascadeType.REMOVE)
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

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
