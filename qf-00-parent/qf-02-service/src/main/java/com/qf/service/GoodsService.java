package com.qf.service;

import com.qf.bean.Goods;

import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 上午 8:41
 */
public interface GoodsService {
    /**
     * 查询所有的商品
     * @return
     */
    List<Goods> queryAll();

    /**
     * 删除指定商品
     * @param id
     */
    void removeGoods(String id);

    /**
     * 商品的新增
     * @param goods
     */
    void addGoods(Goods goods);

    /**
     * 修改商品
     * @param goods
     */
    void updateGoods(Goods goods);
}
