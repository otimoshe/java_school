package com.tsystems.railway.model;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "paths")
public class Path {

    @Id
    @GeneratedValue
    @Column(name = "path_id")
    private int id;


    @ManyToOne
    @JoinColumn( name = "station_id" ,insertable=false, updatable=false)
    private Station station;

    @ManyToOne(targetEntity = Station.class)
    @JoinColumn(name = "next_station_id",insertable=false, updatable=false)
    private Station nextStation;

    @Column(name = "distance")
    private double distance;

    @ManyToMany(mappedBy = "paths")
   // @JoinTable(name = "routes/paths",
          //  joinColumns = @JoinColumn(name = "path_id"),
       //    inverseJoinColumns = @JoinColumn(name = "route_id"))
    private Set<Route> routes = new HashSet<Route>();





    public Path(Station station, Station nextStation, double distance) {
        this.station = station;
        this.nextStation = nextStation;
        this.distance = distance;
    }

    public Path(int id, Station station, Station nextStation, double distance){
        this.station = station;
        this.nextStation = nextStation;
        this.distance = distance;
        this.id = id;
    }

    public Path(){

    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public void setNextStation(Station nextStation) {
        this.nextStation = nextStation;
    }


    public Station getAnotherStation(Station station){
        if (this.station.equals(station)){
            return this.nextStation;
        }
        if (this.nextStation.equals(station)){
            return station;
        }
        return null;
    }







}
