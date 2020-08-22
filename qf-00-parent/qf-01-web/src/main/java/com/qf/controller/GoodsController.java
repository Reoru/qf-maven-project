package com.qf.controller;

import com.qf.bean.Category;
import com.qf.bean.Goods;
import com.qf.bean.User;
import com.qf.constant.PropertyConst;
import com.qf.service.CategoryService;
import com.qf.service.GoodsService;
import com.qf.service.impl.CategoryServiceImpl;
import com.qf.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 下午 16:30
 */
@WebServlet("/goods")
public class GoodsController extends HttpServlet {
    private static final String ADD = "add";
    private static final String DEL = "del";
    private static final String EDIT = "edit";


    private static final String ADD_JSP = "add-index";
    private static final String EDIT_JSP = "edit-index";

    private GoodsService goodsService = new GoodsServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("m");
        User user = (User) req.getSession().getAttribute(PropertyConst.USER_INFO);
        if (user != null) {
            if (ADD_JSP.equals(method)) {

                List<Category> categories = categoryService.queryAll();
                req.setAttribute(PropertyConst.CATEGORY_LIST, categories);
                req.getRequestDispatcher("WEB-INF/page/add-goods.jsp").forward(req, resp);

            } else if (EDIT_JSP.equals(method)) {
                HashMap<String, Goods> map = (HashMap<String, Goods>) req.getSession().getAttribute(PropertyConst.GOODS_LIST);
                String id = req.getParameter("id");
                List<Category> categories = categoryService.queryAll();
                req.setAttribute(PropertyConst.CATEGORY_LIST, categories);
                req.setAttribute(PropertyConst.GOODS_INFO, map.get(id));
                req.getRequestDispatcher("WEB-INF/page/edit.jsp").forward(req, resp);

            } else if (ADD.equals(method)) {
                //初始化参数信息
                Goods goods = new Goods();
                goods.setName(req.getParameter("name"));
                goods.setDescription(req.getParameter("description"));
                goods.setPrice(BigDecimal.valueOf(Double.parseDouble(req.getParameter("price"))));
                goods.setCid(Integer.parseInt(req.getParameter("cid")));
                goodsService.addGoods(goods);
                resp.sendRedirect(req.getContextPath() + "/showGoods");

            } else if (DEL.equals(method)) {
                goodsService.removeGoods(req.getParameter("id"));
            } else if (EDIT.equals(method)) {
                Goods goods = new Goods();
                goods.setId(Integer.parseInt(req.getParameter("id")));
                goods.setName(req.getParameter("name"));
                goods.setDescription(req.getParameter("description"));
                goods.setPrice(BigDecimal.valueOf(Double.parseDouble(req.getParameter("price"))));
                goods.setCid(Integer.parseInt(req.getParameter("cid")));

                goodsService.updateGoods(goods);
                resp.sendRedirect(req.getContextPath() + "/showGoods");
            }
        }
    }
}
