package com.tsystems.railway.DTO;

import com.tsystems.railway.model.Station;

public class StationDTO {
    private long id;

    private String name;

    public StationDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
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


}
