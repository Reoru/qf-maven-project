package com.qf.dao.impl;

import com.qf.bean.User;
import com.qf.dao.LoginDAO;
import com.qf.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 17:07
 */
public class LoginDAOImpl implements LoginDAO {
    @Override
    public User selectUser(String username, String password) {
        //执行sql，返回结果
        List list = JDBCUtil.executeSql(User.class, "select * from tb_user where username = ? and password = ?", username, password);
        return (User) list.get(0);
    }
}
