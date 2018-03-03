package cn.brainysoon.repdata.web;

import cn.brainysoon.repdata.entity.UserEntity;
import cn.brainysoon.repdata.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brainy on 17-7-3.
 */
@RestController
@RequestMapping(value = "/")
public class CommonController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map doLogin(@RequestParam(value = "name") String name,
                       @RequestParam(value = "password") String password) {

        Map result = new HashMap();

        //校验用户名
        if (name == null || name.equals("")) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "请输入账户名!");

            return result;
        }

        //校验密码
        if (password == null || password.equals("")) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "请输入密码!");

            return result;
        }

        //构建登录信息
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, password);

        Subject subject = SecurityUtils.getSubject();

        //尝试登录
        try {

            subject.login(usernamePasswordToken);

            //如果登录成功
            if (subject.isAuthenticated()) {

                result.put(Constant.RESULT_KEY_STATUS, Constant.SUCESSED);
                result.put(Constant.RESULT_KEY_MESSAGE, "登录成功!");

                //放到session
                UserEntity userEntity = userService.getUserByName(name);
                session.setAttribute(Constant.SESSION_KEY_CURRENT_USER, userEntity);
            }

        } catch (IncorrectCredentialsException e) {
            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "登录密码错误");
        } catch (ExcessiveAttemptsException e) {
            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "登录失败次数过多");
        } catch (LockedAccountException e) {
            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "帐号已被锁定");
        } catch (DisabledAccountException e) {
            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "帐号已被禁用");
        } catch (ExpiredCredentialsException e) {
            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "帐号已过期");
        } catch (UnknownAccountException e) {
            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "帐号不存在");
        } catch (Exception e) {
            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "未知异常！");
        }

        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Map doLogout() {

        Map result = new HashMap();

        try {

            //清除回话
            session.removeAttribute(Constant.SESSION_KEY_CURRENT_USER);

            //退出登录
            subject.logout();

            result.put(Constant.RESULT_KEY_STATUS, Constant.SUCESSED);
            result.put(Constant.RESULT_KEY_MESSAGE, "退出成功!");
        } catch (Exception ex) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "出现异常!");
        }

        return result;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map doRegister(@RequestParam(value = "name") String name,
                          @RequestParam(value = "password") String password) {

        Map result = new HashMap();

        //判断空
        if (name == null || name.equals("")) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "用户名不能为空!");
            return result;
        }

        if (password == null || password.equals("")) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "密码不能为空!");

            return result;
        }

        try {

            String id = userService.registerUserByNameAndPassword(name, password);

            result.put(Constant.RESULT_KEY_STATUS, Constant.SUCESSED);
            result.put(Constant.RESULT_KEY_RESULT, id);

        } catch (Exception ex) {

            result.put(Constant.RESULT_KEY_STATUS, Constant.FAILED);
            result.put(Constant.RESULT_KEY_MESSAGE, "注册的时候出现异常!");
        }

        return result;
    }
}
