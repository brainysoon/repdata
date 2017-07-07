package cn.brainysoon.repdata.dao;

import cn.brainysoon.repdata.entity.RepEntity;

import java.util.List;

/**
 * Created by brainy on 17-7-5.
 */
public interface RepDao extends CommonDao<RepEntity, String> {

    /**
     * @param key
     * @return
     */
    List<RepEntity> getRepByKey(String key);
}
