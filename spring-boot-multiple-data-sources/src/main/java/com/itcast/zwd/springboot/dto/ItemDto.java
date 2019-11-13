package com.itcast.zwd.springboot.dto;/**
 * Created by Administrator on 2019/10/13.
 */

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class ItemDto implements Serializable{

    @NotNull
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String code;

    @NotNull
    private Long stock;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String purchaseTime;

    private Integer isActive;

}


















