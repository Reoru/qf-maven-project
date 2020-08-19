package com.qf.test;

import com.qf.util.JDBCUtil;
import org.junit.Test;

import java.sql.Statement;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 19:14
 */
public class DemoTest {

    @Test
    public void test01(){
        Statement statement = JDBCUtil.getStatement();
        System.out.println(statement);
    }
}
