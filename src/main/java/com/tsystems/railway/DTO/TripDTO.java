package com.tsystems.railway.DTO;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


public class TripDTO implements Serializable {

    private int id;

    private RouteDTO route;

    private Date departureDate;

    private TrainDTO train;



    public TripDTO(int id, RouteDTO route, Date departureDate, TrainDTO trainId) {
        this.id = id;
        this.route = route;
        this.departureDate = departureDate;
        this.train = trainId;
    }

    public TripDTO(RouteDTO route, Date departureDate, TrainDTO trainId) {
        this.route = route;
        this.departureDate = departureDate;
        this.train = trainId;
    }

    public TripDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {
        this.route = route;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public TrainDTO getTrain() {
        return train;
    }

    public void setTrain(TrainDTO trainId) {
        this.train = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDTO tripDTO = (TripDTO) o;
        return id == tripDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
