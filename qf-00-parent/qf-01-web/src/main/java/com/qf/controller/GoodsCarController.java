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
    private static final String ADD_GOODS = "add";
    private static final String TEMP_CAR = "tempCar";
    private static final String SHOW_CAR = "show";
    private static final String DEL_GOODS = "del";
    private static final String CLEAR = "clear";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("m");
        // 获取用户信息
        User user = (User) req.getSession().getAttribute(PropertyConst.USER_INFO);
        HashMap<String, Goods> map = (HashMap<String, Goods>) req.getSession().getAttribute(PropertyConst.GOODS_LIST);

        if (ADD_GOODS.equals(method)) {
            //获取作用域中商品集合，用于请求参数ids来获取商品
            //如果id为null，那么就跳过添加，否则添加至临时购物车
            String id = req.getParameter("id");
            Goods goods = map.get(id);

            //非登录状态，数据从临时购物车获取添加
            if (user == null) {

                //非登录状态，将session中的cookie购物车取出
                List<Goods> tempGoods = (List<Goods>) req.getSession().getAttribute(TEMP_CAR);
                if (tempGoods == null) {
                    ArrayList<Goods> list = new ArrayList<>();
                    // 初始化赋值
                    Cookie[] cookies = req.getCookies();
                    for (Cookie cookie : cookies) {
                        cookie.setMaxAge(300);
                        resp.addCookie(cookie);
                    }

                    if (goods != null) {
                        list.add(goods);
                    }
                    Cookie cookie = new Cookie(TEMP_CAR, "online");
                    req.getSession().setAttribute(TEMP_CAR, list);
                    cookie.setMaxAge(300);
                    resp.addCookie(cookie);
                } else {
                    if (goods != null) {
                        tempGoods.add(goods);
                    }
                    return;
                }
            } else {
                System.out.println("登录状态添加...");
                // 登录状态，根据用户的购物车，添加商品
                if (goods != null) {
                    System.out.println("登录添加...");
                    user.getGoodsList().add(goods);
                }
                req.getSession().setAttribute(PropertyConst.USER_INFO, user);
            }

        } else if (SHOW_CAR.equals(method)) {
            // 直接跳转购物车页面
            req.getRequestDispatcher("WEB-INF/page/car-index.jsp").forward(req, resp);
        } else if (DEL_GOODS.equals(method)) {
            // 获取id，删除数据
            String id = req.getParameter("id");
            Goods goods = map.get(id);
            if (user != null) {
                // 登录状态
                user.getGoodsList().remove(goods);
            } else {
                // 非登录状态
                List<Goods> tempGoods = (List<Goods>) req.getSession().getAttribute(TEMP_CAR);
                tempGoods.remove(goods);
            }
        } else if (CLEAR.equals(method)) {
            // 清空购物车
            if (user != null) {
                // 登录状态
                user.getGoodsList().clear();
            } else {
                // 非登录状态
                List<Goods> tempGoods = (List<Goods>) req.getSession().getAttribute(TEMP_CAR);
                tempGoods.clear();
            }
        }

    }
}
