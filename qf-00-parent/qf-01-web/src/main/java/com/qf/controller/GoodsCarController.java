package com.qf.controller;

import com.qf.bean.Goods;
import com.qf.bean.User;
import com.qf.constant.PropertyConst;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 上午 10:43
 */
@WebServlet("/goodsCar")
public class GoodsCarController extends HttpServlet {
    private static final String MY_CAR = "my";
    private static final String TEMP_CAR = "tempCar";
    private static final String SHOW_CAR = "show";
    private static final String GOODS = "goodsId[]";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("m");
        // 获取用户信息
        User user = (User) req.getSession().getAttribute(PropertyConst.USER_INFO);
        if (MY_CAR.equals(method)) {
            //获取作用域中商品集合，用于请求参数ids来获取商品
            HashMap<String, Goods> map = (HashMap<String, Goods>) req.getSession().getAttribute(PropertyConst.GOODS_LIST);
            ArrayList<Goods> goods = new ArrayList<>();

            //整理请求商品数据
            String[] goodsArr = req.getParameterValues(GOODS);
            for (String id : goodsArr) {
                if (map.containsKey(id)) {
                    // 将新添加的商品临时存储
                    goods.add(map.get(id));
                }
            }

            if (user == null) {
                //非登录状态，将session中的cookie购物车取出
                List<Goods> tempGoods = (List<Goods>) req.getSession().getAttribute(TEMP_CAR);
                if (tempGoods == null) {
                    // 初始化赋值
                    /*Cookie[] cookies = req.getCookies();
                    for (Cookie cookie : cookies) {
                        cookie.setMaxAge(300);
                        resp.addCookie(cookie);
                    }*/

                    Cookie cookie = new Cookie(TEMP_CAR, "online");
                    req.getSession().setAttribute(TEMP_CAR, goods);
                    cookie.setMaxAge(300);
                    resp.addCookie(cookie);
                } else {
                    if (goods.size() != 0) {
                        tempGoods.addAll(goods);
                    }
                }
            }

        } else if (SHOW_CAR.equals(method)) {
            // 直接跳转购物车页面
            req.getRequestDispatcher("WEB-INF/page/car-index.jsp").forward(req, resp);
        }
    }
}
