package cn.brainysoon.repdata.service;

import cn.brainysoon.repdata.entity.UserEntity;

/**
 * Created by brainy on 17-7-5.
 */
public interface UserService {

    /**
     * @param id
     * @return
     */
    UserEntity getUserById(String id);

    /**
     * @param userEntity
     * @return
     */
    String saveUser(UserEntity userEntity);
}
