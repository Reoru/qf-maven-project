package qf.test.factory;

import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/21 0021 下午 20:32
 */
public class MapperFactory<T> {
    private static Map<String, Object> map = new HashMap<String, Object>();

    private MapperFactory() {
    }

    static {

    }

    public static void initMappers() {
        // 运用动态代理，扫描配置文件，将指定的包mapper运用动态代理生成对象
        SAXReader saxReader = new SAXReader();


    }


    public static <T> T getMapper(String name, Class<T> clazz) {
        return null;
    }
}
