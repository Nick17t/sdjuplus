package org.sdjusei.sdjulife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:common.properties")
@SpringBootApplication()
@MapperScan("org.sdjusei.sdjulife.dao")
public class SdjulifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdjulifeApplication.class, args);
	}

}

