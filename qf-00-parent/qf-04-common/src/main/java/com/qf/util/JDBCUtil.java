package com.qf.util;

import com.qf.constant.PropertyConst;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

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
    private static Map<String, Integer> columnMap;

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
        } catch (IOException | ClassNotFoundException | SQLException e) {
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

    // 执行ssql
    public static <T> List<T> executeSql(Class<T> clazz, String sql, Object... params) {
        PreparedStatement preparedStatement = null;
        try {
            // 每次请求创建一次预编译对象
            preparedStatement = connection.prepareStatement(sql);

            int index = 1;
            for (Object param : params) {
                preparedStatement.setObject(index++, param);
            }
            // 执行sql
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet != null) {
                //数据收集，反射封装
                collectList(clazz, resultSet);
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 用完关闭
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return resultList;
    }


    // 反射封装
    private static <T> void collectList(Class<T> clazz, ResultSet res) {
        resultList = new ArrayList();
        columnMap = new HashMap<>();
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
                        Method setMethod = getMethodToSet(clazz, res, field);
                        setMethod.invoke(object, res.getObject(columnMap.get(field.getName())));
                    }
                }
                resultList.add(object);
            }

        } catch (SQLException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    // 获取set对象，用于反射封装成bean
    private static <T> Method getMethodToSet(Class<T> clazz, ResultSet res, Field field) throws NoSuchMethodException, SQLException {
        return clazz.getDeclaredMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), res.getObject(columnMap.get(field.getName())).getClass());
    }


    // 获取连接对象
    public static Connection getConnection() {
        return connection;
    }


    // 返回拼接in 语句条件预编译sql
    public static String createInSQL(Object... params) {
        StringBuilder buffer = new StringBuilder("(");
        for (int i = 0; i < params.length; i++) {
            if (i < params.length - 1) {
                buffer.append("?,");
            } else {
                buffer.append("?");
            }
        }
        return buffer.append(")").toString();
    }
}
