package com.tsystems.railway.mappers.Impl;

import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.DTO.StationDTO;
import com.tsystems.railway.mappers.PathMapper;
import com.tsystems.railway.mappers.StationMapper;
import com.tsystems.railway.entity.Path;
import com.tsystems.railway.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PathMapperImpl implements PathMapper {

    @Autowired
    private StationMapper stationMapper;

    @Override
    public Set<Path> dtoSetToEntitySet(Set<PathDTO> pathDTOS) {
        Set<Path> paths =  new HashSet<>();
        for(PathDTO dto: pathDTOS){
            paths.add(this.dtoToEntity(dto));
        }
        return paths;
    }

    @Override
    public Set<PathDTO> entitySetTodtoSet(Set<Path> paths) {
        Set<PathDTO> dtos =  new HashSet<>();
        for(Path path: paths){
            dtos.add(this.entitytoDto(path));
        }
        return dtos;
    }

    @Override
    public PathDTO entitytoDto(Path path) {
        int id = path.getId();
        StationDTO stationDTO = stationMapper.entityToDto(path.getStation());
        StationDTO nextStationDTO = stationMapper.entityToDto(path.getNextStation());
        double distance = path.getDistance();
        return new PathDTO(id,stationDTO,nextStationDTO,distance);
    }

    @Override
    public Path dtoToEntity(PathDTO pathDTO) {
        int id = pathDTO.getId();
        Station station = stationMapper.dtoToEntity( pathDTO.getStation());
        Station nextStation = stationMapper.dtoToEntity( pathDTO.getNextStation());
        double distance = pathDTO.getDistance();
        return new Path(id,station,nextStation,distance);
    }
}
