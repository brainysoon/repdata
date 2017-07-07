package cn.brainysoon.repdata.service.impl;

import cn.brainysoon.repdata.dao.RepDao;
import cn.brainysoon.repdata.entity.RepEntity;
import cn.brainysoon.repdata.service.Constant;
import cn.brainysoon.repdata.service.RepService;
import cn.brainysoon.repdata.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Timestamp;
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

    public List<RepEntity> getRepByUserId(String userId) {
        return repDao.getRepByUserId(userId);
    }

    public RepEntity saveRepByFile(MultipartFile file, String userId) throws Exception {

        //准备数据
        String originName = file.getOriginalFilename();
        String extentsion = originName.substring(originName.lastIndexOf("."), originName.length());
        String fileName = DateTools.getRandomId22() + extentsion;

        //转存
        File fileData = new File(Constant.UPLOAD_FILE_SAVE_PATH, fileName);
        file.transferTo(fileData);

        fileData.setReadable(true, false);

        //存储信息
        RepEntity repEntity = new RepEntity();

        repEntity.setId(DateTools.getRandomId22());
        repEntity.setUserId(userId);
        repEntity.setName(originName);

        //info and label
        //
        repEntity.setSize((int) file.getSize());
        repEntity.setLink(Constant.REP_DATA_ABSTRACT_URL_PRE_PATH + fileName);
        repEntity.setExtension(extentsion);
        repEntity.setOpen(Constant.OPEN_DENIED);        //默认不开源
        repEntity.setMark(Constant.MARK_OK);
        repEntity.setSlead(Constant.SLEAD_ALIVE);
        repEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        //存入数据库
        repDao.save(repEntity);


        return repEntity;
    }

    public RepEntity updateRep(String id, String name, String label, String info, Boolean open) throws Exception {

        RepEntity repEntity = repDao.get(id);

        boolean flag = false;

        //设置数据
        if (name != null && !name.equals("")) {

            repEntity.setName(name);
            flag = true;
        }

        if (label != null && !label.equals("")) {

            repEntity.setLabel(label);
            flag = true;
        }

        if (info != null && !info.equals("")) {

            repEntity.setInfo(info);
            flag = true;
        }

        if (open != null) {

            repEntity.setOpen(open ? 1 : -1);
            flag = true;
        }

        if (flag) {

            repEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        }

        //更新
        repDao.saveOrUpdate(repEntity);

        return repEntity;
    }
}
