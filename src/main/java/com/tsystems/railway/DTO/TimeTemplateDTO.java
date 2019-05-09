package com.tsystems.railway.DTO;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;

public class TimeTemplateDTO {

    private int id;
    private String name;
    private RouteDTO route;
    private HashMap<StationDTO, List<Time>> templateStationMap;

    public TimeTemplateDTO(int id, String name, RouteDTO route, HashMap<StationDTO, List<Time>> templateStation) {
        this.id = id;
        this.name = name;
        this.route = route;
        this.templateStationMap = templateStation;
    }

    public HashMap<StationDTO, List<Time>> getTemplateStation() {
        return templateStationMap;
    }

    public void setTemplateStation(HashMap<StationDTO, List<Time>> templateStation) {
        this.templateStationMap = templateStation;
    }

    public TimeTemplateDTO() {
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

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {
        this.route = route;
    }


}
