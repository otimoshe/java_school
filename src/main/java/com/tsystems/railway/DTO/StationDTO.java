package com.tsystems.railway.DTO;

import java.util.Objects;

public class StationDTO {
    private int id;

    private String name;

    public StationDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StationDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StationDTO(StationDTO stationDTO) {
        this.id = stationDTO.id;
        this.name = stationDTO.name;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationDTO that = (StationDTO) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
