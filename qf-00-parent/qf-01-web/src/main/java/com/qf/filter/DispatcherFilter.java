package com.qf.filter;

import com.qf.bean.User;
import com.qf.constant.PropertyConst;

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


        // 设置不拦截的资源
        for (String str : PropertyConst.URL_PATTERN) {
            if (uri.contains(str)) {
                System.out.println("非拦截页面，放行...");
                filterChain.doFilter(req, resp);
                return;
            }
        }


        //取出session中保存的用户信息，以便自动登录
        User userInfo = (User) req.getSession().getAttribute(PropertyConst.USER_INFO);
        if (userInfo != null) {
            System.out.println("已登录，放行...");
            filterChain.doFilter(req, resp);
            return;
        }

        //既不是非拦截页面，也没有保存session则跳转到登录页面
        System.out.println("暂未登录，转向登录页面...");
        req.getRequestDispatcher("WEB-INF/page/login.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {

    }
}
