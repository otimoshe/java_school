package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.RouteDao;
import com.tsystems.railway.entity.Path;
import com.tsystems.railway.entity.Route;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class RouteDaoImpl implements RouteDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addRoute(Route route) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(route);
    }

    @Override
    public void updateRoute(Route route) {
        Session session = sessionFactory.getCurrentSession();
        session.update(route);
    }

    @Override
    public void deleteRoute(int id) {
        Route route = this.getRouteById(id);
        if (route != null){
            Session session = sessionFactory.getCurrentSession();
            session.delete(route);
        }

    }

    @Override
    public Route getRouteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Route route = (Route)session.load(Route.class,id);
        return route;
    }

    @Override
    public List<Path> getPathList() {
  //    Session session = this.sessionFactory.getCurrentSession();
   //     List<Path> pathList = session.createQuery("from Route").list();
        return null;
    }

    @Override
    public List<Route> getRouteList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Route> routeList = session.createQuery("from Route").list();
        return routeList;
    }
}
