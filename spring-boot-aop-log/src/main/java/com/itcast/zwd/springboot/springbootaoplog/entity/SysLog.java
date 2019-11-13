package com.itcast.zwd.springboot.springbootaoplog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysLog implements Serializable{

    private Long id;

    private String username;

    private String operation;

    private String method;

    private String params;

    private Long time;

    private String ip;

    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}