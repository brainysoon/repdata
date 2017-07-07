package cn.brainysoon.repdata.service.impl;

import cn.brainysoon.repdata.dao.RepDao;
import cn.brainysoon.repdata.entity.RepEntity;
import cn.brainysoon.repdata.service.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by brainy on 17-7-5.
 */
@Service
public class RepServiceImpl implements RepService {

    @Autowired
    private RepDao repDao;

    public List<RepEntity> machRepByKey(String key) {

        return repDao.getRepByKey(key);
    }
}
