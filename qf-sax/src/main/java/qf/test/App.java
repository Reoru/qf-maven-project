package qf.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import qf.test.mapper.UserMapper;
import qf.test.util.MyProxy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DocumentException, ClassNotFoundException, IOException {
        SAXReader saxReader = new SAXReader();
        InputStream is = App.class.getClassLoader().getResourceAsStream("config.xml");
        Document read = saxReader.read(is);
        Element rootElement = read.getRootElement();
        Element packages = rootElement.element("mappers").element("package");
        Attribute path = packages.attribute("path");
        String value = path.getValue();
        String replace = value.replace(".", "/");
        URL url = App.class.getClassLoader().getResources(replace).nextElement();
        String file = url.getFile();
        File file1 = new File(file);
        File[] files = file1.listFiles();
        for (File file2 : files) {
            String replace1 = file2.getName().replace(".class", "");
            Class<?> aClass = Class.forName(value + "." + replace1);
            System.out.println(aClass);
        }
    }

    public void t1(){
        Class<UserMapper> userMapperClass = UserMapper.class;
        MyProxy proxy = new MyProxy();
        UserMapper userMapper = (UserMapper)Proxy.newProxyInstance(App.class.getClassLoader(), new Class[]{userMapperClass}, proxy);
        userMapper.selectOnce();
        userMapper.t1();
    }
}
