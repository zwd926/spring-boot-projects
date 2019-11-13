package com.itcast.zwd.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.itcast.zwd.springboot.mapper")
public class SpringBootMultipleDataSourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultipleDataSourcesApplication.class, args);
	}
}
