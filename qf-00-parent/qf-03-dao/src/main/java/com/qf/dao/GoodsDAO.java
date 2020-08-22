package com.qf.dao;

import com.qf.bean.Goods;

import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 上午 8:43
 */
public interface GoodsDAO {
    /**
     * 列出所有商品
     * @return
     */
    List<Goods> selectAll();

    /**
     * 删除指定商品
     * @param id
     */
    void deleteGoodsById(String id);

    /**
     * 新增商品
     * @param goods
     */
    void insertGoods(Goods goods);

    /**
     * 修改商品
     * @param goods
     */
    void updateGoods(Goods goods);
}
