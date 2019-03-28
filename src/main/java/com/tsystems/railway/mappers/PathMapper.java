package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.entity.Path;

import java.util.List;
import java.util.Set;

public interface PathMapper {
    Set<Path> dtoSetToEntitySet(Set<PathDTO> pathDTOS);

    Set<PathDTO> entitySetTodtoSet(Set<Path> paths);

    PathDTO entitytoDto(Path path);

    Path dtoToEntity(PathDTO pathDTO);

    List<Path> dtoListToEntityList(List<PathDTO> pathDTOS);

    List<PathDTO> entityListTodtoList(List<Path> paths);
}
