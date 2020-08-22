package com.qf.dto;

import com.qf.bean.Goods;
import lombok.Data;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/8/22 0022 下午 14:50
 */

public class GoodsDTO extends Goods {
    private String a;

    @Override
    public String toString() {
        return "GoodsDTO{" +
                "a='" + a + '\'' +
                '}';
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
