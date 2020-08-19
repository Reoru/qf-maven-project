package com.qf.util;

import com.qf.constant.PropertyConst;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.Callable;

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
    private static List resultList;

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

    public static void executeSql(Class<?> clazz, String sql, Object... params) {
        try {
            // 每次请求创建一次预编译对象
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int index = 1;
            for (Object param : params) {
                preparedStatement.setObject(index++, param);
            }
            // 执行sql
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet != null) {
//                resultSet.get
            }

            // 用完关闭
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void collectList(Class<?> clazz, ResultSet res) {
        try {
            ArrayList<String> columnList = new ArrayList<>();
            // 准备获取字段名，根据字段名来映射实体类属性，完成反射封装
            ResultSetMetaData metaData = res.getMetaData();
            int index = 1;
            while (index <= metaData.getColumnCount()) {
                columnList.add(metaData.getColumnName(index++));
            }
            // 将所有字段封装进集合中
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                if (columnList.contains(field.getName())) {
//                    clazz.getDeclaredMethod("set");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




    public static Connection getConnection() {
        return connection;
    }
}
