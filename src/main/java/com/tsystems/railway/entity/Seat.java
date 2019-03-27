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
}

/*
public class SeatStatus {

    @Id
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Id
    @Column(name = " station_id")
    private Station station;

    @Column(name = "available", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean available;
 */