package com.adri.formacion_cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.adri.controller", "com.adri.service"})
public class FormacionClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormacionClienteApplication.class, args);
	}

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}

}
