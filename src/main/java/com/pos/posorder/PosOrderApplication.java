package com.pos.posorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PosOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosOrderApplication.class, args);
	}

}
