package com.qf.service.impl;


import com.qf.dao.LoginDAO;
import com.qf.dao.impl.LoginDAOImpl;
import com.qf.dto.UserDTO;
import com.qf.service.LoginService;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 17:08
 */
public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDAO = new LoginDAOImpl();

    @Override
    public UserDTO queryUser(String username, String password) {
        // 根据用户名密码查询用户并返回
        return loginDAO.selectUser(username, password);
    }
}
