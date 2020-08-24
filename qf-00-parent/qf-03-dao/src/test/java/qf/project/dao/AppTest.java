package qf.project.dao;


import com.qf.dao.GoodsDAO;
import com.qf.dao.LoginDAO;
import com.qf.dao.impl.GoodsDAOImpl;
import com.qf.dao.impl.LoginDAOImpl;
import com.qf.dto.UserDTO;
import org.junit.Test;

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
        UserDTO zhangsan = loginDAO.selectUser("admin", "1");
        System.out.println(zhangsan.getUsername() + " " + zhangsan);
    }
}
