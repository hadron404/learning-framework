package org.example.partition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.partition")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
