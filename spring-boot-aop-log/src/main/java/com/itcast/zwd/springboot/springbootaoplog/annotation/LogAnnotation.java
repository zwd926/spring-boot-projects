package com.itcast.zwd.springboot.springbootaoplog.annotation;

import java.lang.annotation.*;

/**
 * @author 随风逐梦
 * @create 2019-11-13 11:41
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface  LogAnnotation {
    String value() default "";//存储具体的方法操作
}
