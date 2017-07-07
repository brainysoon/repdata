package cn.brainysoon.repdata.service;

import cn.brainysoon.repdata.entity.UserEntity;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * @param userEntity
     * @return
     */
    int updateUser(UserEntity userEntity);

    /**
     * @param id
     * @return
     */
    int deleteUser(String id);

    /**
     * @param name
     * @return
     */
    UserEntity getUserByName(String name);

    /**
     * @param name
     * @param password
     * @return
     */
    String registerUserByNameAndPassword(String name, String password);

    /**
     * @param avator
     * @param id
     * @return
     */
    UserEntity updateAvator(MultipartFile avator, String id) throws Exception;
}
