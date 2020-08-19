package com.qf.test;

import com.qf.bean.User;
import com.qf.util.JDBCUtil;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 19:14
 */
public class DemoTest {

    @Test
    public void test01() {
        Connection connection = JDBCUtil.getConnection();
        List list = JDBCUtil.executeSql(User.class, "select * from tb_user");
        System.out.println(list);

    }
}
