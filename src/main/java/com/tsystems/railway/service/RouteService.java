package com.tsystems.railway.service;

import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.entity.Route;

import java.util.List;

public interface RouteService {

    public void addRoute(Route route);

    public void updateRoute(Route route);

    public void deleteRoute(int id);

    public Route getRouteById(int id);

    public RouteDTO getRouteDTOById(int id);

    public List<Route>getRouteList();

    public List<RouteDTO> getDtoRouteList();

  //  public List<Station> getStationList(Route route);
}
