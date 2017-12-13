package com.josepojr.soreclamacoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication//(scanBasePackages = {"com.josepojr.soreclamacoes.rest", "com.josepojr.soreclamacoes.repositorio"})
public class SoreclamacoesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SoreclamacoesApplication.class, args);
	}
	
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SoreclamacoesApplication.class);
	}
}
