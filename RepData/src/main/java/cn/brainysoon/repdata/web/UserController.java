package cn.brainysoon.repdata.web;

import cn.brainysoon.repdata.entity.UserEntity;
import cn.brainysoon.repdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brainy on 17-7-7.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/upload/avator", method = RequestMethod.POST)
    @ResponseBody
    public Map updateAvator(@RequestParam(value = "avator") MultipartFile imageFile) {

        Map result = new HashMap();

        try {

            UserEntity userEntity = (UserEntity) session.getAttribute(Constant.SESSION_KEY_CURRENT_USER);

            userEntity = userService.updateAvator(imageFile, userEntity.getId());


            if (userEntity != null) {

                result.put(Constant.RESULT_KEY_STATUS, Constant.SUCESSED);
                result.put(Constant.RESULT_KEY_RESULT, userEntity);

                //更新Session
                session.setAttribute(Constant.SESSION_KEY_CURRENT_USER, userEntity);
            } else {

                result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
                result.put(Constant.RESULT_KEY_MESSAGE, "更新失败!");
            }

        } catch (Exception ex) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, Constant.MESSAGE_ERROR_EXCEPTION);
        }

        return result;
    }
}
