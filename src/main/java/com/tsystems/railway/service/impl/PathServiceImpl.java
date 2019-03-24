package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.PathDao;
import com.tsystems.railway.model.Path;
import com.tsystems.railway.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PathServiceImpl implements PathService {

    @Autowired
    private PathDao pathDao;

    public void setPathDao(PathDao pathDao) {
        this.pathDao = pathDao;
    }

    @Override
    public List<Path> getPathList() {
        return pathDao.listPaths();
    }

    @Override
    public void addPath(Path path) {
        pathDao.addPath(path);
    }

    @Override
    public Path getPathById(int id) {
        return pathDao.getPathById(id);
    }

    @Override
    public void deletePath(int id) {
        pathDao.deletePath(id);
    }

    @Override
    public void updatePath(Path path) {
        pathDao.updatePath(path);
    }
}
