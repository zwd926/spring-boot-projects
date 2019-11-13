package com.itcast.zwd.springboot.springbootaoplog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.itcast.zwd.springboot.springbootaoplog.mapper")
public class SpringBootAopLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopLogApplication.class, args);
	}

}
