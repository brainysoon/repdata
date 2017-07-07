package cn.brainysoon.repdata.service.impl;

import cn.brainysoon.repdata.dao.UserDao;
import cn.brainysoon.repdata.entity.UserEntity;
import cn.brainysoon.repdata.service.Constant;
import cn.brainysoon.repdata.service.SecurityService;
import cn.brainysoon.repdata.service.UserService;
import cn.brainysoon.repdata.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by brainy on 17-7-5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SecurityService securityService;

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

    public UserEntity getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public String registerUserByNameAndPassword(String name, String password) {

        UserEntity userEntity = new UserEntity();

        userEntity.setId(DateTools.getRandomId22());
        userEntity.setName(name);

        //加密密码
        Map<String, String> encriptResult = securityService.encodePassword(password, userEntity.getId());

        userEntity.setPassword(encriptResult.get(SecurityService.ENCODE_RESULT_KEY_PASSWORD));
        userEntity.setSlat(encriptResult.get(SecurityService.ENCODE_RESULT_KEY_SALT));

        //其他
        userEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        userEntity.setMark(Constant.MARK_OK);
        userEntity.setSlead(Constant.SLEAD_ALIVE);

        return userDao.save(userEntity);
    }

    public UserEntity updateAvator(MultipartFile avator, String id) throws Exception {

        //存储
        String fileName = DateTools.getRandomId22() + "_src.png";
        File avatorFile = new File(Constant.UPLOAD_AVATOR_SAVE_PATH, fileName);
        avator.transferTo(avatorFile);
        avatorFile.setReadable(true, false);

        //更新
        UserEntity userEntity = userDao.get(id);
        userEntity.setAvator(Constant.USER_AVATOR_URL_PRE_PATH + fileName);

        userEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        userDao.saveOrUpdate(userEntity);

        return userEntity;
    }

    public UserEntity updateUserInfo(String id, String email, String phone, String resume, String github, String address, Date birthday, String domain) throws Exception {

        UserEntity userEntity = userDao.get(id);

        boolean flag = false;

        if (email != null && !email.equals("")) {

            userEntity.setEmail(email);
            flag = true;
        }

        if (phone != null && !phone.equals("")) {

            userEntity.setPhone(phone);
            flag = true;
        }

        if (resume != null && !resume.equals("")) {

            userEntity.setResume(resume);
            flag = true;
        }

        if (github != null && !github.equals("")) {

            userEntity.setGithub(github);
            flag = true;
        }

        if (address != null && !address.equals("")) {

            userEntity.setAddress(address);
            flag = true;
        }

        if (birthday != null) {

            userEntity.setBirthday(birthday);
            flag = true;
        }

        if (domain != null && !domain.equals("")) {

            userEntity.setDomain(domain);
            flag = true;
        }

        if (flag) {

            userEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        }

        userDao.saveOrUpdate(userEntity);

        return userEntity;
    }
}
