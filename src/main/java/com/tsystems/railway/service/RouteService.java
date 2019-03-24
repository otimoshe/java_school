package com.tsystems.railway.service;

import com.tsystems.railway.model.Path;
import com.tsystems.railway.model.Route;
import com.tsystems.railway.model.Station;

import java.util.List;

public interface RouteService {

    public void addRoute(Route route);

    public void updateRoute(Route route);

    public void deleteRoute(int id);

    public Route getRouteById(int id);

    public List<Route>getRouteList();

  //  public List<Station> getStationList(Route route);
}
