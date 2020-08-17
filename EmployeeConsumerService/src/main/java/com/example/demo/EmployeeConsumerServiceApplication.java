package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.example.demo.controller.ConsumerController;

@SpringBootApplication
public class EmployeeConsumerServiceApplication {

	public static void main(String[] args) throws RestClientException, IOException {

		ApplicationContext ctx = SpringApplication.run(EmployeeConsumerServiceApplication.class, args);
		ConsumerController cclient = ctx.getBean(ConsumerController.class);

		System.out.println(cclient);
		cclient.getEmployee();

	}

	@Bean
	public ConsumerController consumerControllerClient() {
		return new ConsumerController();
	}

}
