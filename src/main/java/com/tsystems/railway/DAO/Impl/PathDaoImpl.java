package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.PathDao;
import com.tsystems.railway.model.Path;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(readOnly = false)
public class PathDaoImpl implements PathDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addPath(Path path) {
        Session session = sessionFactory.getCurrentSession();
        session.persist (path);
    }

    @Override
    public List<Path> listPaths() {
        Session session = sessionFactory.getCurrentSession();
        List<Path> pathList =  session.createQuery("from Path").list();
        return pathList;
    }

    @Override
    public void deletePath(int id) {
        Path path = this.getPathById(id);
        if (path != null){
            Session session = sessionFactory.getCurrentSession();
            session.delete(path);
        }
    }

    @Override
    public void updatePath(Path path) {
        Session session = sessionFactory.getCurrentSession();
        session.update(path);
    }

    @Override
    public Path getPathById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Path path = (Path) session.load(Path.class,id);
        return path;
    }
}
