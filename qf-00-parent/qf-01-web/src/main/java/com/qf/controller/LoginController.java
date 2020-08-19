package com.qf.controller;

import com.qf.service.LoginService;
import com.qf.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 16:30
 */

@WebServlet("/login")
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

        loginService.queryUser();
    }
}
