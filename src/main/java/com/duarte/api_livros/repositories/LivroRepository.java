package com.duarte.api_livros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duarte.api_livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	List<Livro> findByCategoria(String categoria);
	
	List<Livro> findByAutor(String autor);
	
}
