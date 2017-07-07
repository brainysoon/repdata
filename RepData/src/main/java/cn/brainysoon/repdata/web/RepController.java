package cn.brainysoon.repdata.web;

import cn.brainysoon.repdata.entity.RepEntity;
import cn.brainysoon.repdata.entity.UserEntity;
import cn.brainysoon.repdata.service.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brainy on 17-7-7.
 */
@RestController
@RequestMapping("/")
public class RepController extends BaseController {

    @Autowired
    private RepService repService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Map search(@RequestParam(value = "key") String key) {

        Map result = new HashMap();

        try {

            result.put(Constant.RESULT_KEY_RESULT, repService.machRepByKey(key));
            result.put(Constant.RESULT_KEY_STATUS, Constant.SUCESSED);

        } catch (Exception ex) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "搜索的时候出现异常!");
        }

        return result;
    }

    @RequestMapping(value = "/rep/listrep", method = RequestMethod.GET)
    public Map listAll() {

        Map result = new HashMap();

        //登录用户
        UserEntity userEntity = (UserEntity) session.getAttribute(Constant.SESSION_KEY_CURRENT_USER);

        //查找当前用户的所有文件
        try {

            List<RepEntity> repEntities = repService.getRepByUserId(userEntity.getId());

            result.put(Constant.RESULT_KEY_STATUS, Constant.SUCESSED);
            result.put(Constant.RESULT_KEY_RESULT, repEntities);

        } catch (Exception ex) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, Constant.MESSAGE_ERROR_EXCEPTION);
        }

        return result;
    }
}
