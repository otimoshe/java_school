package com.tsystems.railway.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="stations")
public class Station {

    @Id
    @Column(name = "station_id")
    private long id;

    @Column(name = "name")
    private String name;
}
