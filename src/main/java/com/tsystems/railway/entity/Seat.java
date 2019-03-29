package com.tsystems.railway.entity;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue
    @Column(name = "seat_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "number")
    private  int number;

    @OneToMany(mappedBy = "seat",cascade = CascadeType.ALL)
    private Set<SeatStatus> seatStatuses;

    public Seat( int id, Trip trip, int number, Set<SeatStatus> seatStatuses) {
        this.id = id;
        this.trip = trip;
        this.number = number;
        this.seatStatuses = seatStatuses;
    }

    public Seat() {
    }

    public Seat(int id,Trip trip, Set<SeatStatus> seatStatuses) {
        this.id = id;
        this.trip = trip;
        this.seatStatuses = seatStatuses;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Set<SeatStatus> getSeatStatuses() {
        return seatStatuses;
    }

    public void setSeatStatuses(Set<SeatStatus> seatStatuses) {
        this.seatStatuses = seatStatuses;
    }


}

