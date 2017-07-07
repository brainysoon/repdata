package cn.brainysoon.repdata.dao.impl;

import cn.brainysoon.repdata.dao.UserDao;
import cn.brainysoon.repdata.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by brainy on 17-7-5.
 */
@Repository
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

        return (UserEntity) this.getCurrentSession().get(UserEntity.class, id);
    }

    public List<UserEntity> findAll() {
        return this.getCurrentSession().createQuery("from user where slead>0").list();
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

    public int delete(String id) {
        return this.getCurrentSession().createSQLQuery(String
                .format("UPDATE user SET slead=-1 WHERE id='%s'", id))
                .executeUpdate();
    }

    public void flush() {

        this.getCurrentSession().flush();
    }

    public UserEntity getUserByName(String name) {

        UserEntity userEntity = null;

        try {

            userEntity = (UserEntity) this.getCurrentSession().createSQLQuery(
                    String.format("SELECT * FROM user WHERE name='%s'", name)
            ).addEntity(UserEntity.class).list().get(0);
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return userEntity;

    }
}
