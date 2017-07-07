package cn.brainysoon.repdata.web;

import cn.brainysoon.repdata.service.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
        }

        return result;
    }
}
