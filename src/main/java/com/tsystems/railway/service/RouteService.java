package com.tsystems.railway.service;

import com.tsystems.railway.DTO.AddRouteForm;
import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.entity.Route;

import java.util.List;

public interface RouteService {

     void addRoute(RouteDTO route);

     void updateRoute(RouteDTO route);

     void deleteRoute(int id);

     Route getRouteById(int id);

     RouteDTO getRouteDTOById(int id);

     List<Route>getRouteList();

     List<RouteDTO> getDtoRouteList();

     void addRoute(AddRouteForm form);
}
