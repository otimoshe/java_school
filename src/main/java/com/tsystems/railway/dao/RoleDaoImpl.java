package com.tsystems.railway.dao;

import com.tsystems.railway.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class RoleDaoImpl  implements RoleDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Role getRoleById(Long id) {
        Session session =this.sessionFactory.getCurrentSession();
        Role role = (Role) session.load(Role.class, id);
        return role;
    }
}
