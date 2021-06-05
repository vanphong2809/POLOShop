package com.phong.poloshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.phong.poloshop")
public class PoloShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoloShopApplication.class, args);
	}
}
