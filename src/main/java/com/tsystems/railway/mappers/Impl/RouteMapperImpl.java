package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.mappers.PathMapper;
import com.tsystems.railway.mappers.RouteMapper;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RouteMapperImpl implements RouteMapper {

    @Autowired
    private StationMapper stationMapper;

    @Autowired
    private PathMapper pathMapper;

    @Override
    public Route dtoToEntity(RouteDTO routeDTO) {
        int id = routeDTO.getId();
        String name = routeDTO.getName();
        BigDecimal price = routeDTO.getPrice();
        StationDTO stationDTO = routeDTO.getFirstStation();
        Set<PathDTO> paths = routeDTO.getPaths();
        return new Route(id,name,price,stationMapper.dtoToEntity(stationDTO),pathMapper.dtoSetToEntitySet(paths));
    }

    @Override
    public RouteDTO entityToDto(Route route) {
        int id = route.getId();
        String name = route.getName();
        BigDecimal price = route.getPrice();
        StationDTO stationDTO = stationMapper.entityToDto(route.getFirstStation());
        Set<PathDTO> paths = pathMapper.entitySetTodtoSet(route.getPaths());
        List<StationDTO> stationDTOList = stationMapper.listEntityToDtoList(route.getStationList());

        return new RouteDTO(id,price,name,stationDTO,paths,stationDTOList);
    }

    @Override
    public List<RouteDTO> listEntityToDtoList(List<Route> routeList) {
        List<RouteDTO> dtoList = new ArrayList<>();
        for (Route route:routeList){
            dtoList.add(this.entityToDto(route));
        }
        return dtoList;
    }

    @Override
    public List<Route> listDtoToEntityList(List<RouteDTO> dtoList) {
        List<Route> list = new ArrayList<>();
        for(RouteDTO dto:dtoList){
            list.add(this.dtoToEntity(dto));
        }
        return list;
    }
}
