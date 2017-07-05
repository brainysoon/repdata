package cn.brainysoon.repdata.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by brainy on 17-7-5.
 */
public interface CommonDao<T, PK extends Serializable> {

    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();
}