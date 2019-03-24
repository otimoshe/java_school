package com.tsystems.railway.mappers;

import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.model.Path;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PathMapperImpl implements PathMapper{

    public Set<Path> dtoSetToEntitySet(Set<PathDTO> pathDTOSet){return null;}
    public Set<PathDTO> entitySetTodtoSet(Set<Path> paths){return null;}

}
