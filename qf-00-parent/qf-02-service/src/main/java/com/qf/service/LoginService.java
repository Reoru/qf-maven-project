package com.qf.service;

import com.qf.bean.User;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 16:31
 */
public interface LoginService {
    /**
     * 查询用户信息
     * @return
     * @param username
     * @param password
     */
    User queryUser(String username, String password);
}
