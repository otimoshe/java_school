package com.tsystems.railway.model;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
//@Proxy(lazy=false)
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue
    @Column(name = "train_id")
    public long id;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @ManyToMany
    @JoinTable(name = "schedule",
            joinColumns = @JoinColumn(name = "train_id"),
            inverseJoinColumns = @JoinColumn(name = "departure_station_id"))
    private Set<Station> stations;

    @ManyToMany
    @JoinTable(name = "tickets",
            joinColumns = @JoinColumn(name = "train_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private List<Passenger> passengers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }


    public Set<Station> getStations() {
        return stations;
    }

    public void setStations(Set<Station> stations) {
        this.stations = stations;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", numberOfSeats=" + numberOfSeats +
            //    ", stations=" + stations +
           //     ", passengers=" + passengers +
                '}';
    }

}
