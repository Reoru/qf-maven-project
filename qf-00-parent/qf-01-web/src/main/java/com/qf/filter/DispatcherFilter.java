package com.qf.filter;

import javax.annotation.processing.Filer;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 19:39
 */
public class DispatcherFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();
        String autoLogin = req.getParameter("autoLogin");
        System.out.println("auto:------>" + autoLogin);

        // 检测是否是登录页面的请求
        if ("/login".equals(uri)) {
            filterChain.doFilter(req, resp);
            return;
        } else {
            //取出session中保存的用户信息，以便自动登录
            Cookie[] cookies = req.getCookies();
            System.out.println("session = " + req.getSession());
            if (Objects.nonNull(cookies)) {
                for (Cookie cookie : cookies) {
                    System.out.println("cookie=name：" + cookie.getName() + ",value=" + cookie.getValue());
                    if (req.getSession().getAttribute(cookie.getName()) != null) {
                        System.out.println("找到指定的cookie,放行...");
                        filterChain.doFilter(req, resp);
                        return;
                    }
                }
            }
        }

        //既不是登录页面，也没有保存session则跳转到登录页面
        System.out.println("暂未登录，转向登录页面...");
        req.getRequestDispatcher("WEB-INF/page/login.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {

    }
}
