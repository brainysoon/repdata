package cn.brainysoon.repdata.service;

import cn.brainysoon.repdata.entity.RepEntity;

import java.util.List;

/**
 * Created by brainy on 17-7-5.
 */
public interface RepService {

    /**
     * @param key
     * @return
     */
    List<RepEntity> machRepByKey(String key);
}
