package com.examportal.examportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  // ✅ Add this to enable scheduled tasks
public class ExamportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}
}
