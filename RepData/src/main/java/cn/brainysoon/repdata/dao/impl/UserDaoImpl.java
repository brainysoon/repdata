package cn.brainysoon.repdata.dao.impl;

import cn.brainysoon.repdata.dao.UserDao;
import cn.brainysoon.repdata.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by brainy on 17-7-5.
 */
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {

        return this.sessionFactory.getCurrentSession();
    }

    public UserEntity load(String id) {
        return (UserEntity) this.getCurrentSession().load(UserEntity.class, id);
    }

    public UserEntity get(String id) {
        return (UserEntity) this.getCurrentSession().load(UserEntity.class, id);
    }

    public List<UserEntity> findAll() {
        return this.getCurrentSession().createQuery("from user").list();
    }

    public void persist(UserEntity entity) {

        this.getCurrentSession().persist(entity);
    }

    public String save(UserEntity entity) {
        return (String) this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(UserEntity entity) {

        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(String id) {
        this.getCurrentSession().delete(id);
    }

    public void flush() {

        this.getCurrentSession().flush();
    }
}
