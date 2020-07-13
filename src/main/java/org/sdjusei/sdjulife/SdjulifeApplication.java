package org.sdjusei.sdjulife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SdjulifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdjulifeApplication.class, args);
	}

}

