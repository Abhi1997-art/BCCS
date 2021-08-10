package com.service.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
@RestController
public class BankingApplication {

	public static void main(String[] args) {
		System.out.println("Application is Starting ............");
		SpringApplication.run(BankingApplication.class, args);

	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World from bank bccs";
	}
}
