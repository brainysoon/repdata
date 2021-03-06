package cn.brainysoon.repdata.dao.impl;

import cn.brainysoon.repdata.dao.RepDao;
import cn.brainysoon.repdata.entity.RepEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by brainy on 17-7-5.
 */
@Repository
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
        return this.getCurrentSession().createQuery("from rep WHERE slead>0").list();
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

    public int delete(String id) {

        return this.getCurrentSession().createSQLQuery(String
                .format("UPDATE rep SET slead=-1 WHERE id='%s'", id))
                .executeUpdate();
    }

    public void flush() {

        this.getCurrentSession().flush();
    }

    public List<RepEntity> getRepByKey(String key) {

        return this.getCurrentSession().createSQLQuery(
                String.format("SELECT * from rep where rep.name like '%s' OR rep.label like '%s'", key, key))
                .addEntity(RepEntity.class)
                .list();
    }

    public List<RepEntity> getRepByUserId(String userId) {
        return this.getCurrentSession().createSQLQuery(
                String.format("SELECT * FROM rep WHERE rep.userId='%s'", userId)
        ).addEntity(RepEntity.class).list();
    }
}
