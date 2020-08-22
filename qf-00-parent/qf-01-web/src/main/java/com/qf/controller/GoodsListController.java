package com.qf.controller;

import com.qf.bean.Goods;
import com.qf.constant.PropertyConst;
import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 上午 8:37
 */
@WebServlet("/showGoods")
public class GoodsListController extends HttpServlet {
    private GoodsService goodsService = new GoodsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 列出所有商品
        goodsList(req, resp);
    }


    private void goodsList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Goods> goodsList = goodsService.queryAll();
        // 将商品集合进行作用域初始化赋值
        HashMap<String, Goods> map = new HashMap<>();
        for (Goods goods : goodsList) {
            map.put(goods.getId().toString(), goods);
        }
        req.getSession().setAttribute(PropertyConst.GOODS_LIST, map);
        req.getRequestDispatcher("WEB-INF/page/goods-index.jsp").forward(req, resp);
    }
}
