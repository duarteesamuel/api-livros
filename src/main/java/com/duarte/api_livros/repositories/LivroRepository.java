package com.duarte.api_livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duarte.api_livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
}
