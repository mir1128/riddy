package com.loobo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class RiddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{RiddyApplication.class, SchedulerConfigurer.class}, args);
	}
}
