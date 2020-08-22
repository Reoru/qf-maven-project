package qf.project.dao;

import static org.junit.Assert.assertTrue;

import com.qf.bean.Category;
import com.qf.bean.Goods;
import com.qf.bean.User;
import com.qf.dao.GoodsDAO;
import com.qf.dao.LoginDAO;
import com.qf.dao.impl.GoodsDAOImpl;
import com.qf.dao.impl.LoginDAOImpl;
import com.qf.util.JDBCUtil;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private GoodsDAO goodsDAO = new GoodsDAOImpl();
    private LoginDAO loginDAO = new LoginDAOImpl();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
       loginDAO.selectUser("zhangsan", "2");
    }
}
