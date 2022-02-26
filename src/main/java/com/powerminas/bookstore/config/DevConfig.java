package com.powerminas.bookstore.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String auto;
	
	@Bean
	public boolean populaBaseDeDados() {
		
		if(auto.equals("create")) {
			System.out.println("Cadastrando os dados na base de dados: ");
		}
		
		return true;
	}

}
