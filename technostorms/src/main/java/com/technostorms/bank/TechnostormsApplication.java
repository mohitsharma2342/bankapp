package com.technostorms.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
/* @EntityScan(basePackages = {"com.tecnostorms.bank.model"}) */
public class TechnostormsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnostormsApplication.class, args);
	}

}
