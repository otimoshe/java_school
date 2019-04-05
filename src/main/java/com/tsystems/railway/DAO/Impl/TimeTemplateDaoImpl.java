package com.tsystems.railway.DAO.Impl;

import com.tsystems.railway.DAO.TimeTemplateDao;
import com.tsystems.railway.entity.TimeTemplate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class TimeTemplateDaoImpl implements TimeTemplateDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addTimeTempalte(TimeTemplate timeTemplate) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(timeTemplate);
    }

    @Override
    public void deleteTimeTemplate(int id) {
        Session session = sessionFactory.getCurrentSession();
        TimeTemplate timeTemplate = this.getTimeTemplateById(id);
        if (timeTemplate != null){
            session.delete(timeTemplate);
        }
    }

    @Override
    public void updateTimeTemplate(TimeTemplate timeTemplate) {
        Session session = sessionFactory.getCurrentSession();
        session.update(timeTemplate);
    }

    @Override
    public TimeTemplate getTimeTemplateById(int id) {
        Session session = sessionFactory.getCurrentSession();
        TimeTemplate timeTemplate = (TimeTemplate) session.load(TimeTemplate.class,id);
        return timeTemplate;
    }

    @Override
    public List<TimeTemplate> getListTimeTemplatesForRoute(int routeId) {
        Session session = sessionFactory.getCurrentSession();
        List<TimeTemplate> list = session.createQuery("from TimeTemplate where route_id = "+routeId).list();
        return list;
    }

    @Override
    public List<TimeTemplate> getTimeTemplatesList() {
        Session session = sessionFactory.getCurrentSession();
        List<TimeTemplate> list = session.createQuery("from TimeTemplate").list();
        return list;
    }
}
