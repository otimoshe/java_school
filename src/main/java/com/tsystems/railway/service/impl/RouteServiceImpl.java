package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.RouteDao;
import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.entity.Route;
import com.tsystems.railway.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Autowired
    private RouteMapper routeMapper;

    @Override
    public void addRoute(Route route) {
        routeDao.addRoute(route);
    }

    @Override
    public void updateRoute(Route route) {
        routeDao.updateRoute(route);
    }

    @Override
    public void deleteRoute(int id) {
        routeDao.deleteRoute(id);
    }

    @Override
    public Route getRouteById(int id) {
        return routeDao.getRouteById(id);
    }

    @Override
    public RouteDTO getRouteDTOById(int id) {
        return routeMapper.entityToDto(routeDao.getRouteById(id));
    }

    @Override
    public List<Route> getRouteList() {
        return routeDao.getRouteList();
    }

    @Override
    public List<RouteDTO> getDtoRouteList() {
        return this.routeMapper.listEntityToDtoList(this.getRouteList());
    }

    /* @Override
    public List<Station> getStationList(Route route) {
        Set<Path> paths = route.getPaths();
        List<Station> stationList = new ArrayList<Station>();
        Station firstStation = route.getFirstStation();
        Station currentStation = firstStation;

        while (!paths.isEmpty()) {
            for (Path path : paths) {
                if (path.getStation().equals(currentStation)) {
                    stationList.add(path.getStation());
                    stationList.add(path.getNextStation());
                    currentStation = path.getNextStation();
                    paths.remove(path);
                    break;
                }
                if (path.getNextStation().equals(currentStation)) {
                    stationList.add(path.getNextStation());
                    stationList.add(path.getStation());
                    currentStation = path.getStation();
                    paths.remove(path);
                    break;
                }
            }
        }
        return stationList;
    }*/
}
