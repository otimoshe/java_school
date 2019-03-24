package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.DTO.RouteDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class RouteMapperImpl implements RouteMapper{

    @Autowired
    private StationMapper stationMapper;

    @Autowired
    private PathMapper pathMapper;

    @Override
    public Route dtoToEntity(RouteDTO routeDTO) {
        String name = routeDTO.getName();
        BigDecimal price = routeDTO.getPrice();
        StationDTO stationDTO = routeDTO.getFirst_station();
        Set<PathDTO> pathDTOS = routeDTO.getPathsDTOSet();
        return new Route(name,price,stationMapper.dtoToEntity(stationDTO),pathMapper.dtoSetToEntitySet(pathDTOS));
    }

    @Override
    public RouteDTO entityToDto(Route route) {
        int id = route.getId();
        String name = route.getName();
        BigDecimal price = route.getPrice();
        StationDTO stationDTO = stationMapper.entityToDto(route.getFirstStation());
        Set<PathDTO> pathDTOS = pathMapper.entitySetTodtoSet(route.getPaths());

        return new RouteDTO(id,price,name,stationDTO,pathDTOS);
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
