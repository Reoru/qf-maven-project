package com.qf.filter;

import com.qf.bean.User;
import com.qf.constant.PropertyConst;
import com.qf.dto.UserDTO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/24 0024 下午 14:19
 */
public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI();
        for (String str : PropertyConst.getUrlArr()) {
            if (uri.endsWith(str)) {
                System.out.println(str);
                System.out.println("[权限]非拦截页面，放行...");
                filterChain.doFilter(req, resp);
                return;
            }
        }

        UserDTO user = (UserDTO) req.getSession().getAttribute(PropertyConst.USER_INFO);
        if (user != null) {
            List<String> permissions = user.getPermissions();
            System.out.println(user);
            for (String permission : permissions) {
                System.out.println("权限 ===> " + permission + ", URI ====> " + uri);
                if (uri.contains(permission)) {
                    // 如果拥有权限，则放行
                    System.out.println("拥有该URI权限,放行...");
                    filterChain.doFilter(req, resp);
                    return;
                }
            }
            // 跳转到未授权页面
            req.getRequestDispatcher("WEB-INF/page/non-permission.jsp").forward(req, resp);
        } else {
            // 未登录则重定向到登录页面
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}
