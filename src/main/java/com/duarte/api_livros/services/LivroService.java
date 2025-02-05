package com.duarte.api_livros.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duarte.api_livros.entities.Livro;

@Service
public class LivroService {
	
	private final List<Livro> livros = new ArrayList<>();
	
	//Methods
	
	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}
}
