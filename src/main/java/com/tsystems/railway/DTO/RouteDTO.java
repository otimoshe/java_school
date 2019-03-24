package com.tsystems.railway.DTO;




import java.math.BigDecimal;
import java.util.Set;

public class RouteDTO {
    private int id;
    private BigDecimal price;
    private String name;
    private StationDTO first_station;
    private Set<PathDTO> pathsDTOSet;

    public Set<PathDTO> getPathsDTOSet() {
        return pathsDTOSet;
    }

    public void setPathsDTOSet(Set<PathDTO> pathsDTOSet) {
        this.pathsDTOSet = pathsDTOSet;
    }

    public StationDTO getFirst_station() {
        return first_station;
    }

    public void setFirst_station(StationDTO first_station) {
        this.first_station = first_station;
    }

    public RouteDTO(int id, BigDecimal price, String name, StationDTO first_station,Set<PathDTO> pathsDTOSet) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.first_station = first_station;
        this.pathsDTOSet = pathsDTOSet;
    }

    public RouteDTO(BigDecimal price, String name,StationDTO first_station,Set<PathDTO> pathsDTOSet) {
        this.price = price;
        this.name = name;
        this.first_station = first_station;
        this.pathsDTOSet = pathsDTOSet;
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
