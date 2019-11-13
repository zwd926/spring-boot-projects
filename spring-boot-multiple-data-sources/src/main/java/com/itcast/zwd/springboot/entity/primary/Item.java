package com.itcast.zwd.springboot.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private Integer id;

    private String name;

    private String code;

    private Long stock;

    private Date purchaseTime;

    private Integer isActive;

    private Date createTime;

    private Date updateTime;

    public Item(String name, String code, Long stock) {
        this.name = name;
        this.code = code;
        this.stock = stock;
    }
}