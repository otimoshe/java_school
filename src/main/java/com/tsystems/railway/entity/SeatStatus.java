package com.tsystems.railway.entity;


import javax.persistence.*;

@Entity
@Table(name = "seat_status")
public class SeatStatus {

    @Id
    @GeneratedValue
    @Column(name = "seat_status_id")
    private int id;

    @Column(name = " seat_status_name")
    private String name;

    public SeatStatus(int id,String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
