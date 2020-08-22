package com.qf.dao;

import com.qf.bean.Category;

import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 下午 17:29
 */
public interface CategoryDAO {
    /**
     * 查询所有分类
     * @return
     */
    List<Category> selectAll();
}
