package com.jobboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.jobboard.model")
public class JobBoardApplication {
	public static void main(String[] args) {
		SpringApplication.run(JobBoardApplication.class, args);
	}
}
