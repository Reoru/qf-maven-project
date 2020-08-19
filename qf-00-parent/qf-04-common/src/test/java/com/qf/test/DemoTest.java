package com.qf.test;

import com.qf.util.JDBCUtil;
import org.junit.Test;

import java.sql.*;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 19:14
 */
public class DemoTest {

    @Test
    public void test01() {
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement p = connection.prepareStatement("select * from tb_user");
            p.execute();
            int index = 1;
            ResultSet resultSet = p.getResultSet();
            ResultSetMetaData metaData = p.getMetaData();

            while (index <= metaData.getColumnCount()) {
                String columnName = metaData.getColumnName(index++);
                System.out.println("字段名：" + columnName);
            }

            index = 1;
            while (resultSet.next()) {
                System.out.println("值："+resultSet.getObject(index++) + " , " + resultSet.getObject(index++));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
