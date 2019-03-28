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

    @OneToMany(mappedBy = "seat",fetch = FetchType.EAGER)
    private Set<SeatStatus> seatStatuses;

    public Seat(Trip trip, Set<SeatStatus> seatStatuses) {
        this.trip = trip;
        this.seatStatuses = seatStatuses;
    }

    public Seat() {
    }

    public Seat(int id,Trip trip, Set<SeatStatus> seatStatuses) {
        this.id = id;
        this.trip = trip;
        this.seatStatuses = seatStatuses;
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

