package com.qf.service;

import com.qf.bean.Goods;

import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 下午 20:41
 */
public interface UserService {

    /**
     * 查询指定用户的所有商品信息
     * @param id
     * @return
     */
    List<Goods> queryGoodsByUid(Integer id);

    /**
     * 为指定用户添加商品
     * @param id
     * @param id1
     */
    void addGoodsByUser(Integer id, Integer id1);
}
