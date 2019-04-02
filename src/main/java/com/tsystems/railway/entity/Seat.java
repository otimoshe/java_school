package com.tsystems.railway.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

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

    @OneToMany(mappedBy = "seat")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<SeatStatus> seatStatuses;

    public boolean isAvailable(Station  arrivalStation,Station departureStation ){
        List<Station> stations =  this.trip.getRoute().getStationList(); //all stations from route
        HashMap<Station,Boolean> statuses = new HashMap<>();
        for(SeatStatus status:seatStatuses){
            statuses.put(status.getStation(),status.isAvailable());
        }
        int start =  stations.indexOf(arrivalStation);
        int end = stations.indexOf(departureStation);
        List<Station> stationsForCheck = stations.subList(start,end); // list staions for checks
        for(Station station:stationsForCheck){
            if( statuses.get(station) == false){
                return false;
            }
        }
        return true ;
    }


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

