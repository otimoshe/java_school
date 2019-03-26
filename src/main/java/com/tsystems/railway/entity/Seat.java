package com.tsystems.railway.entity;

import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue
    @Column(name = "seat_id")
    private int id;

    @Column(name = "trip_id")
    private Trip trip;
}
