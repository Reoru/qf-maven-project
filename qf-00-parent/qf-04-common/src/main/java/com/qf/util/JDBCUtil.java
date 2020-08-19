package com.qf.util;

import com.qf.constant.PropertyConst;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 16:46
 */
public class JDBCUtil {
    private static String username;
    private static String password;
    private static String url;
    private static Connection connection;
    private static Statement statement;

    // 私有化构造
    private JDBCUtil() {
    }

    // 静态初始化连接
    static {
        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            username = properties.getProperty(PropertyConst.USER_NAME);
            password = properties.getProperty(PropertyConst.PASS_WORD);
            url = properties.getProperty(PropertyConst.URL);

            if (username != null && password != null && url != null) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Statement对象
     *
     * @return
     */
    public static Statement getStatement() {

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }


    //统一关闭所有资源
    public static void closes() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
