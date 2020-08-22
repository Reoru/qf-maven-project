package com.qf.controller;

import com.qf.bean.User;
import com.qf.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/21 0021 上午 10:09
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    public String getUser(HttpServletRequest req) {
        System.out.println("[controller] - this is controller");
        User user = userService.queryUser();
        req.setAttribute("user", user);
        return "index";
    }
}
