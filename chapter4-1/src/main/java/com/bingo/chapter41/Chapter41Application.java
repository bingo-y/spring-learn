package com.bingo.chapter41;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Chapter41Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter41Application.class, args);
	}
}
