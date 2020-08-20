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
public class AppTest 
{
    private GoodsDAO goodsDAO = new GoodsDAOImpl();

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        List<Goods> goods = JDBCUtil.executeSql(Goods.class, "select * from tb_goods");
        System.out.println(goods);
    }
}
