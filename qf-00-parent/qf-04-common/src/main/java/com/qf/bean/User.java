package com.qf.bean;

import java.util.List;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 16:33
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer logout;
    // 购物车
    private List<Goods> goodslist;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLogout() {
        return logout;
    }

    public void setLogout(Integer logout) {
        this.logout = logout;
    }

    public List<Goods> getGoodslist() {
        return goodslist;
    }

    public void setGoodslist(List<Goods> goodslist) {
        this.goodslist = goodslist;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", logout=" + logout +
                ", goodslist=" + goodslist +
                '}';
    }
}
