package com.itcast.zwd.springboot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

/**
 * @author 随风逐梦
 * @create 2019-11-05 13:51
 */

@Data
public class Student {

    @Id
    private String id;

    @NotNull
    private String studentId;

    private Integer age;

    private String name;

    private String gender;

}
