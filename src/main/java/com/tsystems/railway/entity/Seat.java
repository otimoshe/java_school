package com.tsystems.railway.entity;



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

    @OneToMany(mappedBy = "seat",cascade = CascadeType.ALL)
    private Set<SeatStatus> seatStatuses = new HashSet<>();

    public boolean isAvailable(Station departureStation,Station  arrivalStation ){
        List<Station> stations =  this.trip.getRoute().getStationList(); //all stations from route
        HashMap<Station,Boolean> statuses = new HashMap<>();
        for(SeatStatus status:this.seatStatuses){
            statuses.put(status.getStation(),status.isAvailable());
        }
        int start =  stations.indexOf(departureStation);
        int end = stations.indexOf(arrivalStation);
        List<Station> stationsForCheck = stations.subList(start,end); // list staions for checks
        for(Station station:stationsForCheck){
            if( statuses.get(station) == false){
                return false;
            }
        }
        return true ;
    }

    public Seat( int id, Trip trip, int number, HashSet<SeatStatus> seatStatuses) {
        this.id = id;
        this.trip = trip;
        this.number = number;
        this.seatStatuses = seatStatuses;
    }

    public Seat() {
    }

    public Seat(int id,Trip trip, HashSet<SeatStatus> seatStatuses) {
        this.id = id;
        this.trip = trip;
        this.seatStatuses = seatStatuses;
    }

    public Seat(  Trip trip, int number, HashSet<SeatStatus> seatStatuses) {
        this.trip = trip;
        this.number = number;
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

    public void setSeatStatuses(HashSet<SeatStatus> seatStatuses) {
        this.seatStatuses = seatStatuses;
    }


}

