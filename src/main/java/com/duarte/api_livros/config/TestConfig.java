package com.duarte.api_livros.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.duarte.api_livros.entities.Livro;
import com.duarte.api_livros.repositories.LivroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void run(String... args) throws Exception{
		
		Livro livro1 = new Livro(null, "O Enigma das Estrelas",
				"Lucas Pereira",
				LocalDate.now(),
				"Ficção Científica",
				"Em estoque");
		
		Livro livro2 = new Livro(null, "O Último Suspiro",
				"Mariana Costa",
				LocalDate.now(),
				"Romance",
				"Esgotado");
		
		Livro livro3 = new Livro(null, "Mentes Brilhantes",
				"José Almeida",
				LocalDate.now(),
				"Psicologia",
				"Em estoque");
		
		Livro livro4 = new Livro(null, "A Viagem no Tempo",
				"Fernanda Silva",
				LocalDate.now(),
				"Aventura",
				"Pré-venda");
		
		Livro livro5 = new Livro(null, "Cozinhando com Sabor",
				"Ana Ribeiro",
				LocalDate.now(),
				"Culinária",
				"Em Estoque");
		
		livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
		
	}
	
}
