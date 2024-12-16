package com.ecommerce.microservices.product_service;

import com.ecommerce.microservices.ProductServiceApplication;
import org.springframework.boot.SpringApplication;

public class TestProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProductServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
