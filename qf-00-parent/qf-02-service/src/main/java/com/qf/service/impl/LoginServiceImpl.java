package com.qf.service.impl;

import com.qf.bean.User;
import com.qf.dao.LoginDAO;
import com.qf.dao.impl.LoginDAOImpl;
import com.qf.service.LoginService;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 17:08
 */
public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDAO = new LoginDAOImpl();

    @Override
    public User queryUser(String username, String password) {
        return loginDAO.selectUser(username,password);
    }
}
