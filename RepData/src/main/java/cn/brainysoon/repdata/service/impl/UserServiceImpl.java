package cn.brainysoon.repdata.service.impl;

import cn.brainysoon.repdata.dao.UserDao;
import cn.brainysoon.repdata.entity.UserEntity;
import cn.brainysoon.repdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by brainy on 17-7-5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserEntity getUserById(String id) {
        return userDao.get(id);
    }

    public String saveUser(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    public int updateUser(UserEntity userEntity) {

        try {

            userDao.saveOrUpdate(userEntity);

            return 1;
        } catch (Exception ex) {

            return -1;
        }

    }

    public int deleteUser(String id) {
        return userDao.delete(id);
    }
}
