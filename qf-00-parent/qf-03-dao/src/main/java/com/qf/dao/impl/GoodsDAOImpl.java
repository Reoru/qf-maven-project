package com.qf.dao.impl;

import com.qf.bean.Category;
import com.qf.bean.Goods;
import com.qf.dao.GoodsDAO;
import com.qf.util.JDBCUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 上午 8:43
 */
public class GoodsDAOImpl implements GoodsDAO {
    @Override
    public List<Goods> selectAll() {
        HashMap<Integer, String> map = new HashMap<>();
        // 将查询到的商品结果集返回
        List<Goods> goodsList = JDBCUtil.executeSql(Goods.class, "select * from tb_goods");
        List<Category> cateList = JDBCUtil.executeSql(Category.class, "select * from tb_category");
        for (Category category : cateList) {
            map.put(category.getId(), category.getName());
        }

        System.out.println(map);

        // 进行商品与分类映射
        for (Goods goods : goodsList) {
            if (map.containsKey(goods.getCid())) {
                goods.setCategory(map.get(goods.getCid()));
            }
        }

        return goodsList;
    }

    @Override
    public void deleteGoodsById(String id) {
        JDBCUtil.executeSql(null,"delete from tb_goods where id = ?",id);
    }

    @Override
    public void insertGoods(Goods goods) {
        JDBCUtil.executeSql(null,"insert into tb_goods (name,description,price,cid) values (?,?,?,?)",goods.getName(),goods.getDescription(),goods.getPrice(),goods.getCid());
}

    @Override
    public void updateGoods(Goods goods) {
        JDBCUtil.executeSql(null,"update tb_goods set name = ? , description = ? , price = ? , cid = ? where id = ?",goods.getName(),goods.getDescription(),goods.getPrice(),goods.getCid(),goods.getId());
    }
}
