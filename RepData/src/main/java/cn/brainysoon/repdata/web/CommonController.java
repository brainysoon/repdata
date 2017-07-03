package cn.brainysoon.repdata.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by brainy on 17-7-3.
 */
@Controller
@RequestMapping(value = "/")
public class CommonController extends BaseController {

    @RequestMapping(value = {"/", "index"})
    public String index() {

        return "index";
    }
}
