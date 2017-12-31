package com.imcs.syed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EntityScan( basePackages = {"com.imcs.syed"} )
public class OrderLibSoapServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderLibSoapServiceApplication.class, args);
	}
}
