package cn.brainysoon.repdata.service;

import cn.brainysoon.repdata.entity.RepEntity;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * @param userId
     * @return
     */
    List<RepEntity> getRepByUserId(String userId);

    /**
     * @param file
     * @return
     */
    RepEntity saveRepByFile(MultipartFile file, String userId) throws Exception;

    /**
     * @param id
     * @param name
     * @param label
     * @param info
     * @param open
     * @return
     */
    RepEntity updateRep(String id, String name, String label, String info, Boolean open) throws Exception;
}
