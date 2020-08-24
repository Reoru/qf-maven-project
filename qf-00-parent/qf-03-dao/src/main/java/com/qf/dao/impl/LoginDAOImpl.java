package com.qf.dao.impl;

import com.qf.bean.Permission;
import com.qf.bean.Role;
import com.qf.bean.User;
import com.qf.dao.LoginDAO;
import com.qf.dto.UserDTO;
import com.qf.util.BeanUtils;
import com.qf.util.JDBCUtil;

import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 17:07
 */
public class LoginDAOImpl implements LoginDAO {
    @Override
    public UserDTO selectUser(String username, String password) {
        //执行sql，返回结果
        List list = JDBCUtil.executeSql(User.class, "select * from tb_user where username = ? and password = ?", username, password);
        // 进行权限的检索
        User user = (User) list.get(0);
        UserDTO userDTO = BeanUtils.copy(user, UserDTO.class);

        // 取出用户所拥有的角色信息
        List<Role> roles = JDBCUtil.executeSql(Role.class, "SELECT * FROM tb_role where id in (SELECT rid from tb_user_role_rel where uid = ?)", userDTO.getId());
        //整理角色id，用于查询对应角色所拥有的权限
        Integer[] ids = new Integer[roles.size()];
        for (int i = 0; i < roles.size(); i++) {
            ids[i] = roles.get(i).getId();
        }
        List<Permission> permissions = JDBCUtil.executeSql(Permission.class, "select * from tb_permission where id in ( select pid from tb_role_permission_ral where rid in " + JDBCUtil.createInSQL(ids) + ")", ids);
        //为用户映射所拥有的权限
        permissions.stream().forEach(userDTO::addPermission);
        //映射用户所拥有的所有角色
        userDTO.setRoles(roles);
        return userDTO;
    }
}
