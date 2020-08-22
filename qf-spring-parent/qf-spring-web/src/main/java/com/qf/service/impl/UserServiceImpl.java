package com.qf.service.impl;

import com.qf.bean.User;
import com.qf.mapper.UserMapper;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/21 0021 上午 10:12
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser() {
        System.out.println("[service] - this is service...");
        // 返回用户信息
        return userMapper.selectOnce();
    }
}
