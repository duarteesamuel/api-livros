package com.duarte.api_livros.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.duarte.api_livros.repositories.LivroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void run(String... args) throws Exception{
		//Implementar lógica
	}
	
}
