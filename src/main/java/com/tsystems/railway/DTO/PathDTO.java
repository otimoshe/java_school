package com.tsystems.railway.DTO;



public class PathDTO {
    private int id;
    private StationDTO station;
    private StationDTO nextStation;
    private double distance;

    public int getId() {
        return id;
    }

    public PathDTO(int id, StationDTO station, StationDTO next_station, double distance) {
        this.id = id;
        this.station = station;
        this.nextStation = next_station;
        this.distance = distance;
    }

    public PathDTO() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public StationDTO getStation() {
        return station;
    }

    public void setStation(StationDTO station) {
        this.station = station;
    }

    public StationDTO getNextStation() {
        return nextStation;
    }

    public void setNextStation(StationDTO next_station) {
        this.nextStation = next_station;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
