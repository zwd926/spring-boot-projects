package com.itcast.zwd.springboot.entity.primary;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String name;

    private String code;

    private String email;
}