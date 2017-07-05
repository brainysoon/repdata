package cn.brainysoon.repdata.dao.impl;

import cn.brainysoon.repdata.dao.RepDao;
import cn.brainysoon.repdata.entity.RepEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by brainy on 17-7-5.
 */
public class RepDaoImpl implements RepDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {

        return this.sessionFactory.getCurrentSession();
    }

    public RepEntity load(String id) {
        return (RepEntity) this.getCurrentSession().load(RepEntity.class, id);
    }

    public RepEntity get(String id) {
        return (RepEntity) this.getCurrentSession().get(RepEntity.class, id);
    }

    public List<RepEntity> findAll() {
        return this.getCurrentSession().createQuery("from rep").list();
    }

    public void persist(RepEntity entity) {

        this.getCurrentSession().persist(entity);
    }

    public String save(RepEntity entity) {
        return (String) this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(RepEntity entity) {

        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(String id) {

        this.getCurrentSession().delete(id);
    }

    public void flush() {

        this.getCurrentSession().flush();
    }
}
