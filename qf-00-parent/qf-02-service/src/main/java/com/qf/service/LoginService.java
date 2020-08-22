package com.qf.service;


import com.qf.dto.UserDTO;

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
    UserDTO queryUser(String username, String password);
}
