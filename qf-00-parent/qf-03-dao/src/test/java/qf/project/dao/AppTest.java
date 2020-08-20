package qf.project.dao;

import static org.junit.Assert.assertTrue;

import com.qf.bean.Category;
import com.qf.bean.Goods;
import com.qf.dao.GoodsDAO;
import com.qf.dao.impl.GoodsDAOImpl;
import com.qf.util.JDBCUtil;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private GoodsDAO goodsDAO = new GoodsDAOImpl();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        List list = goodsDAO.selectAll();
        System.out.println(list);
    }
}
