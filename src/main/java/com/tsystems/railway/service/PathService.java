package com.tsystems.railway.service;

import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.entity.Path;

import java.util.List;

public interface PathService  {

    public void addPath(PathDTO path);

    public PathDTO getPathById(int id);

    public void deletePath(int id);

    public void updatePath(PathDTO path);

    public List<PathDTO>getPathList();
}
