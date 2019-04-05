package com.tsystems.railway.entity;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name ="stations")
public class Station {

    @Id
    @GeneratedValue
    @Column(name = "station_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "station")
    private Set<SeatStatus> seatStatuses;

    @OneToMany(mappedBy = "departureStation")
    private Set<Ticket> departureTicket;

    @OneToMany(mappedBy = "arrivalStation")
    private Set<Ticket> arrivalTicket;

    @OneToMany(mappedBy = "station")
    private Set<TemplateStation> templateStations;


    public Station(String name) {
        this.name = name;
    }

    public Station() {
    }

    public Station(int id, String name) {
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

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return id == station.id &&
                name.equals(station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
