package com.tsystems.railway.service.impl;

import com.tsystems.railway.DAO.PathDao;
import com.tsystems.railway.DTO.PathDTO;
import com.tsystems.railway.entity.Path;
import com.tsystems.railway.mappers.PathMapper;
import com.tsystems.railway.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PathServiceImpl implements PathService {

    @Autowired
    private PathDao pathDao;

    @Autowired
    private PathMapper pathMapper;

    public void setPathDao(PathDao pathDao) {
        this.pathDao = pathDao;
    }

    @Override
    public List<PathDTO> getPathList() {
        return pathMapper.entityListTodtoList(pathDao.listPaths());
    }

    @Override
    public void addPath(PathDTO path) {
        pathDao.addPath(pathMapper.dtoToEntity(path));
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
    public void updatePath(PathDTO path) {
        pathDao.updatePath(pathMapper.dtoToEntity(path));
    }
}
