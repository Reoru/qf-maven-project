package com.qf.service.impl;

import com.qf.bean.Category;
import com.qf.dao.CategoryDAO;
import com.qf.dao.impl.CategoryDAOImpl;
import com.qf.service.CategoryService;

import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 下午 17:28
 */
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    @Override
    public List<Category> queryAll() {
        return categoryDAO.selectAll();
    }
}
