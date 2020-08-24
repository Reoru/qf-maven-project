package com.qf.constant;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 16:49
 * <p>
 * <p>
 * JDBC连接属性资源文件的key名类
 */
public class PropertyConst {

    public static final String USER_NAME = "username";

    public static final String PASS_WORD = "password";

    public static final String URL = "url";

    public static final String GOODS_INFO = "goodsInfo";

    public static final String USER_INFO = "userInfo";

    public static final String GOODS_LIST = "goodsList";

    public static final String CATEGORY_LIST = "categoryList";

    private static String[] urlArr;

    static {
        urlArr = new String[]{
                "/json", ".js", ".css", ".ico", ".jpg", ".png",
                "showGoods", "/", "/login", "goodsCar"
        };
    }

    public static String[] getUrlArr() {
        return urlArr;
    }
}
