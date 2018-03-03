package cn.brainysoon.repdata.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Created by brainy on 17-7-3.
 */
public class BaseController {

    protected Session session;
    protected Subject subject;

    public BaseController() {

        //得到当前用户的 Subject
        subject = SecurityUtils.getSubject();
        session = subject.getSession();
    }
}
