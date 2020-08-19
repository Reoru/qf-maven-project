package com.qf.dao.impl;

import com.qf.bean.User;
import com.qf.dao.LoginDAO;
import com.qf.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 17:07
 */
public class LoginDAOImpl implements LoginDAO {
    @Override
    public User selectUser() {
        Statement statement = JDBCUtil.getStatement();
        try {
            ResultSet resultSet = statement.executeQuery("select * from tbl_student");
            while (resultSet.next()) {
                System.out.println(resultSet.getObject(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
