package com.qf.bean;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/19 0019 下午 16:34
 */
public class Goods {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer cid;
    private String category;

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", cid=" + cid +
                ", category='" + category + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) &&
                Objects.equals(name, goods.name) &&
                Objects.equals(description, goods.description) &&
                Objects.equals(price, goods.price) &&
                Objects.equals(cid, goods.cid) &&
                Objects.equals(category, goods.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, cid, category);
    }
}
