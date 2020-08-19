package com.qf.bean;

import java.math.BigDecimal;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 16:34
 */
public class Goods {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer cid;

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", cid=" + cid +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
