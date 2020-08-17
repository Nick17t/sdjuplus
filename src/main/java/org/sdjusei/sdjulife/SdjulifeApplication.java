package org.sdjusei.sdjulife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
@EnableScheduling
@MapperScan("org.sdjusei.sdjulife.dao")
public class SdjulifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdjulifeApplication.class, args);
	}

}

