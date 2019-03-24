package com.tsystems.railway.service;

import com.tsystems.railway.model.Path;

import java.util.List;

public interface PathService  {

    public void addPath(Path path);

    public Path getPathById(int id);

    public void deletePath(int id);

    public void updatePath(Path path);

    public List<Path>getPathList();
}
