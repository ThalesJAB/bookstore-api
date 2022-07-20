package br.com.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.bookstore.service.DBService;

@Configuration
@Profile("prod")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaBaseDeDados() {
		
		if(strategy.equals("create")) {
			this.dbService.instanciaBasedeDados();
		}
		
		return false;
		
	}
	
	
	
	
	
	

}
