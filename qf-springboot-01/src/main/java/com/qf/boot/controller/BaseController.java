package com.qf.boot.controller;

import com.qf.boot.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/29 0029 下午 14:20
 */
@Controller
@RequestMapping("/index")
public class BaseController {

    @PostMapping("test")
    @ResponseBody
    public String toTest(@RequestBody User user) {
        // 模拟已注册的用户
        User u = new User();
        u.setUsername("admin");
        u.setPassword("1");
        return u.equals(user) ? "已注册!" : "注册成功!";
    }

}
