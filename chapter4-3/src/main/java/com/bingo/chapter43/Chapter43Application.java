package com.bingo.chapter43;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Chapter43Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter43Application.class, args);
	}
}
