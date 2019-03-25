package com.tsystems.railway.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="stations")
public class Station {

    @Id
    @GeneratedValue
    @Column(name = "station_id")
    private long id;

    @Column(name = "name")
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public Station() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
