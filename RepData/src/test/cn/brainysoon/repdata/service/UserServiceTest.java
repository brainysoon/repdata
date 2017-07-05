package cn.brainysoon.repdata.service;

import cn.brainysoon.repdata.entity.UserEntity;
import cn.brainysoon.repdata.utils.DateTools;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

/**
 * Created by brainy on 17-7-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void userSaveTest() {

        UserEntity userEntity = new UserEntity();

        userEntity.setId(DateTools.getRandomId22());
        userEntity.setName("brainysoon");
        userEntity.setPassword("sxc19940115");
        userEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        userEntity.setMark(1);
        userEntity.setSlead(1);
        userEntity.setSlat("lala");

        String result = userService.saveUser(userEntity);

        Assert.assertNotNull(result);
    }
}
