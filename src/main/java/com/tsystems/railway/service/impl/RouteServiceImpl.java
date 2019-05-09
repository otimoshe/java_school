package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.RouteDao;
import com.tsystems.railway.DTO.AddRouteForm;
import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.entity.Route;
import com.tsystems.railway.service.PathService;
import com.tsystems.railway.service.RouteService;
import com.tsystems.railway.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Autowired
    private RouteMapper routeMapper;

    @Autowired
    private StationService stationService;

    @Autowired
    private PathService pathService;

    @Override
    public void addRoute(RouteDTO route) {
        routeDao.addRoute(routeMapper.dtoToEntity(route));
    }
    @Override
    public void addRoute(AddRouteForm form){
        RouteDTO route = new RouteDTO();
        route.setName(form.getName());
        route.setFirstStation(stationService.getStationById(form.getFirstStationId()));
        route.setPrice(form.getPrice());
        Set<PathDTO> paths = new HashSet<>();
        for(String id:form.getPathIds()){
            paths.add(pathService.getPathById(Integer.parseInt(id)));
        }
        route.setPaths(paths);
        this.addRoute(route);

    }

    @Override
    public void updateRoute(RouteDTO route) {
        routeDao.updateRoute(routeMapper.dtoToEntity(route));
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

}
