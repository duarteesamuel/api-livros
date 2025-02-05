package com.duarte.api_livros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duarte.api_livros.entities.Livro;
import com.duarte.api_livros.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	//Methods
	public List<Livro> findAll(){
		return livroRepository.findAll();
	}
	
	public Livro findById(Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		
		return livro.get();
	}
	
}
