package com.qf.dto;

import com.qf.bean.Permission;
import com.qf.bean.Role;
import com.qf.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/22 0022 上午 8:46
 */

public class UserDTO extends User {
    // 所有用户所拥有的角色与权限
    private List<String> permissions;
    private List<Role> roles;

    public UserDTO() {
        this.permissions = new ArrayList<>();
        this.roles = new ArrayList<>();
    }

    public void addPermission(Permission p) {
        permissions.add(p.getUrl());
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "permissions=" + permissions +
                ", roles=" + roles +
                '}';
    }
}
