package com.tsystems.railway.DTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class TicketForm {
    private int trainId;
    private String routeName;
    private Date departureDate;
    private Time departureTime;
    private Date arriveDate;
    private Time arriveTime;
    private BigDecimal price;
    private int tripId;
    private int departStationId;
    private int arriveStationId;
    private int seatId;
    private int passengerId;


    public int getDepartStationId() {
        return departStationId;
    }

    public void setDepartStationId(int departStationId) {
        this.departStationId = departStationId;
    }

    public int getArriveStationId() {
        return arriveStationId;
    }

    public void setArriveStationId(int arriveStationId) {
        this.arriveStationId = arriveStationId;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }


    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public Time getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TicketForm(int trainId, String routeName, Date departureDate, Time departureTime, Date arriveDate, Time arriveTime, BigDecimal price, int tripId) {
        this.trainId = trainId;
        this.routeName = routeName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arriveDate = arriveDate;
        this.arriveTime = arriveTime;
        this.price = price;
        this.tripId = tripId;
    }

    public TicketForm(int trainId, String routeName, Date departureDate, Time departureTime, Date arriveDate, Time arriveTime, BigDecimal price, int tripId, int departStationId, int arriveStationId) {
        this.trainId = trainId;
        this.routeName = routeName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arriveDate = arriveDate;
        this.arriveTime = arriveTime;
        this.price = price;
        this.tripId = tripId;
        this.departStationId = departStationId;
        this.arriveStationId = arriveStationId;
    }

    public TicketForm() {
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }
}
