package com.tsystems.railway.DTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class RouteDTO {
    private int id;
    private BigDecimal price;
    private String name;
    private StationDTO first_station;
    private Set<PathDTO> paths;
    private List<StationDTO> stationList;

    public List<StationDTO> getStationList() {
        return stationList;
    }

    public void setStationList(List<StationDTO> stationList) {
        this.stationList = stationList;
    }

    public RouteDTO(int id, BigDecimal price, String name, StationDTO first_station, Set<PathDTO> paths, List<StationDTO> stationList) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.first_station = first_station;
        this.paths = paths;
        this.stationList = stationList;
    }



    public Set<PathDTO> getPaths() {
        return paths;
    }

    public void setPaths(Set<PathDTO> paths) {
        this.paths = paths;
    }

    public StationDTO getFirstStation() {
        return first_station;
    }

    public void setFirstStation(StationDTO first_station) {
        this.first_station = first_station;
    }

    public RouteDTO() {
    }

    public RouteDTO(int id, BigDecimal price, String name, StationDTO first_station, Set<PathDTO> paths) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.first_station = first_station;
        this.paths = paths;
    }

    public RouteDTO(BigDecimal price, String name,StationDTO first_station,Set<PathDTO> paths) {
        this.price = price;
        this.name = name;
        this.first_station = first_station;
        this.paths = paths;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
