package cn.brainysoon.repdata.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin() {

        return "login";
    }
}
