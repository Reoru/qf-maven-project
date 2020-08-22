package com.qf.dto;

import com.qf.bean.Goods;
import com.qf.bean.Permission;
import com.qf.bean.Role;
import com.qf.bean.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/22 0022 上午 8:46
 */

@Data
public class UserDTO extends User {
    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public Integer getLogout() {
        return super.getLogout();
    }

    @Override
    public void setLogout(Integer logout) {
        super.setLogout(logout);
    }

    @Override
    public List<Goods> getGoodsList() {
        return super.getGoodsList();
    }

    @Override
    public void setGoodsList(List<Goods> goodsList) {
        super.setGoodsList(goodsList);
    }

    // 所有用户所拥有的角色与权限
    List<String> permissions = new ArrayList<>();
    private List<Role> roles = new ArrayList<>();

    public void addPermission(Permission p) {
        permissions.add(p.getUrl());
    }
}
