package com.duarte.api_livros.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.duarte.api_livros.entities.Cliente;
import com.duarte.api_livros.entities.Livro;
import com.duarte.api_livros.repositories.ClienteRepository;
import com.duarte.api_livros.repositories.LivroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	public void run(String... args) throws Exception{
		
		Livro livro1 = Livro.builder()
                .titulo("O Enigma das Estrelas")
                .autor("Lucas Pereira")
                .anoFabricacao(LocalDate.now())
                .categoria("Ficção Científica")
                .disponibilidade("Em estoque")
                .build();

        Livro livro2 = Livro.builder()
                .titulo("O Último Suspiro")
                .autor("Mariana Costa")
                .anoFabricacao(LocalDate.now())
                .categoria("Romance")
                .disponibilidade("Esgotado")
                .build();

        Livro livro3 = Livro.builder()
                .titulo("Mentes Brilhantes")
                .autor("José Almeida")
                .anoFabricacao(LocalDate.now())
                .categoria("Psicologia")
                .disponibilidade("Em estoque")
                .build();

        Livro livro4 = Livro.builder()
                .titulo("A Viagem no Tempo")
                .autor("Fernanda Silva")
                .anoFabricacao(LocalDate.now())
                .categoria("Aventura")
                .disponibilidade("Pré-venda")
                .build();

        Livro livro5 = Livro.builder()
                .titulo("Cozinhando com Sabor")
                .autor("Ana Ribeiro")
                .anoFabricacao(LocalDate.now())
                .categoria("Culinária")
                .disponibilidade("Em Estoque")
                .build();

        livroRepository.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5));
		
		
        Cliente cliente1 = Cliente.builder()
                .nome("Samuel Duarte")
                .cpf("123.456.789-11")
                .build();

        Cliente cliente2 = Cliente.builder()
                .nome("Gabriela Fontenele")
                .cpf("123.654.888-01")
                .build();

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));
	}
	
}
