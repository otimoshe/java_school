package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.model.Path;

import java.util.Set;

public interface PathMapper {
    Set<Path> dtoSetToEntitySet(Set<PathDTO> pathDTOS);
    Set<PathDTO> entitySetTodtoSet(Set<Path> paths);
}
