package com.lm.waxmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lm.waxmanager.mapper")
public class WaxmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaxmanagerApplication.class, args);
	}
}
