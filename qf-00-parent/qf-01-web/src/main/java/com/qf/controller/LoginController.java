package com.qf.controller;

import com.qf.bean.User;
import com.qf.constant.PropertyConst;
import com.qf.service.LoginService;
import com.qf.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 16:30
 */

public class LoginController extends HttpServlet {
    private LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is login----");
        // 获取前台的用户名密码
        System.out.println("LoginServlet.doGet");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String login = req.getParameter("autoLogin");
        System.out.println("auto:--->" + login);
        User user = loginService.queryUser(username, password);

        System.out.println("userInfo--->" + user);
        if (user != null) {
            // 用户存在
            if ("on".equals(login)) {
                Cookie[] cookies = req.getCookies();
                for (Cookie cookie : cookies) {
                    cookie.setMaxAge(60);
                    resp.addCookie(cookie);
                }

                Cookie cookie = new Cookie(PropertyConst.USER_INFO, user.getUsername());
                cookie.setMaxAge(60);
                resp.addCookie(cookie);
            }
            req.getSession().setAttribute(PropertyConst.USER_INFO, user);
            req.getRequestDispatcher("WEB-INF/page/goods-index.jsp").forward(req, resp);
        }
    }
}
