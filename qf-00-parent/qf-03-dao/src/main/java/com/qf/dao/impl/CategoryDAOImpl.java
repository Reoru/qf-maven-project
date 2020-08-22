package com.qf.dao.impl;

import com.qf.bean.Category;
import com.qf.dao.CategoryDAO;
import com.qf.util.JDBCUtil;

import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 下午 17:29
 */
public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public List<Category> selectAll() {
        return JDBCUtil.executeSql(Category.class, "select * from tb_category");
    }
}
