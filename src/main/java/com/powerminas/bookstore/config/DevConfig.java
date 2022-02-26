package com.powerminas.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.powerminas.bookstore.services.PopularBase;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private PopularBase base;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String auto;
	
	@Bean
	public boolean populaBaseDeDados() {
		
		if(auto.equals("create")) {
			System.out.println("Cadastrando os dados na base de dados: ");
			base.popular();
		}
		
		return true;
	}

}
