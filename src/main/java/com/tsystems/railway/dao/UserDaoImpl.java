package com.tsystems.railway.dao;


import com.tsystems.railway.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override

    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }



    @Override

    public User findByUsername(String username){
        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createQuery("from User where user_name = :name");
        query.setParameter("name", username);
        List<User> users = query.list();
        if (users.isEmpty() ){
            return  null;
        }
        return users.get(0);
    }
}
