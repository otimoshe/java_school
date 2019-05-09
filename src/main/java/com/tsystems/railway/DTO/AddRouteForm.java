package com.tsystems.railway.DTO;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AddRouteForm {

    private String name;
    private BigDecimal price;
    private ArrayList<String> pathIds;
    private int firstStationId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public ArrayList<String> getPathIds() {
        return pathIds;
    }

    public void setPathIds(ArrayList<String> pathIds) {
        this.pathIds = pathIds;
    }

    public int getFirstStationId() {
        return firstStationId;
    }

    public void setFirstStationId(int firstStationId) {
        this.firstStationId = firstStationId;
    }

    public AddRouteForm() {
        pathIds = new ArrayList<>();
    }
}
