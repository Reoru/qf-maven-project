package com.qf.util;

import com.qf.constant.PropertyConst;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 16:46
 */
public class JDBCUtil<T> {
    private static String username;
    private static String password;
    private static String url;
    private static Connection connection;
    private static Statement statement;
    private static List resultList = new ArrayList();
    private static Map<String, Integer> columnMap = new HashMap<>();

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

    public static <T> List executeSql(Class<T> clazz, String sql, Object... params) {
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
                collectList(clazz, resultSet);
            }

            // 用完关闭
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }


    private static <T> void collectList(Class<T> clazz, ResultSet res) {
        try {
            // 准备获取字段名，根据字段名来映射实体类属性，完成反射封装
            ResultSetMetaData metaData = res.getMetaData();
            int index = 1;
            while (index <= metaData.getColumnCount()) {
                //完成列名与位置索引的映射
                int temp = index;
                columnMap.put(metaData.getColumnName(index++), temp);
            }

            System.out.println(columnMap);

            Field[] declaredFields = clazz.getDeclaredFields();
            while (res.next()) {
                // 每行映射一个对象
                T object = clazz.newInstance();
                for (Field field : declaredFields) {
                    if (columnMap.containsKey(field.getName())) {
                        // 如果有对应映射字段，那么就进行属性赋值s
                        Method setMethod = clazz.getDeclaredMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), res.getObject(columnMap.get(field.getName())).getClass());
                        setMethod.invoke(object, res.getObject(columnMap.get(field.getName())));
                    }
                }

                resultList.add(object);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        return connection;
    }
}
