package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Path;
import com.tsystems.railway.entity.Route;

import java.util.List;

public interface RouteDao {

    public void addRoute(Route route);

    public void updateRoute(Route route);

    public void deleteRoute(int id);

    public Route getRouteById(int id);

    public List<Route> getRouteList();

    public List<Path> getPathList();
}
