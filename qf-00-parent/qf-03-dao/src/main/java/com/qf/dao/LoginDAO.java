package com.qf.dao;

import com.qf.dto.UserDTO;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 17:06
 */
public interface LoginDAO {
    UserDTO selectUser(String username, String password);
}
