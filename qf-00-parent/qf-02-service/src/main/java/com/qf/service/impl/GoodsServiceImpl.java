package com.qf.service.impl;

import com.qf.bean.Goods;
import com.qf.dao.GoodsDAO;
import com.qf.dao.impl.GoodsDAOImpl;
import com.qf.service.GoodsService;

import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 上午 8:41
 */
public class GoodsServiceImpl implements GoodsService {
    private GoodsDAO goodsDAO = new GoodsDAOImpl();
    @Override
    public List<Goods> queryAll() {
        return goodsDAO.selectAll();
    }

    @Override
    public void removeGoods(String id) {
        goodsDAO.deleteGoodsById(id);
    }

    @Override
    public void addGoods(Goods goods) {
        goodsDAO.insertGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        goodsDAO.updateGoods(goods);
    }
}
