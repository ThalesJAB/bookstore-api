package br.com.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.bookstore.service.DBService;

@Configuration
@Profile("prod")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	
	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBasedeDados();
	}

}
