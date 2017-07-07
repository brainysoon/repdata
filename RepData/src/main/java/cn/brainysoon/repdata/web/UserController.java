package cn.brainysoon.repdata.web;

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

    @RequestMapping(value = "/upload/avator", method = RequestMethod.POST)
    @ResponseBody
    public Map updateAvator(@RequestParam(value = "avator") MultipartFile imageFile) {

        Map result = new HashMap();

        try {


        } catch (Exception ex) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, Constant.MESSAGE_ERROR_EXCEPTION);
        }

        return result;
    }
}
