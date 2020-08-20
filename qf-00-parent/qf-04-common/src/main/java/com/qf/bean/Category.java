package com.qf.bean;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/20 0020 上午 8:53
 */
public class Category {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
