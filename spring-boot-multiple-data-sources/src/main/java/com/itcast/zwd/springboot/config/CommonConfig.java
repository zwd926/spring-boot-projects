package com.itcast.zwd.springboot.config;

import com.github.dadiyang.equator.Equator;
import com.github.dadiyang.equator.FieldBaseEquator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 随风逐梦
 * @create 2019-11-13 15:58
 */
@Configuration
public class CommonConfig {

    @Bean
    public Equator equator(){
        Equator equator = new FieldBaseEquator();
        return equator;
    }
}
