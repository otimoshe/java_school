package com.tsystems.railway.entity;

import javax.persistence.*;

@Entity
@Table(name = "time_template")
public class TimeTemplate {

    @Column(name = "template_id")
    @GeneratedValue
    @Id
    private int id;

    @Column(name = "template_name")
    private String name;

    @Column(name = "route_id")
    private Route route;
}
