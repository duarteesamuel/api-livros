package com.duarte.api_livros.dtos;

import java.time.LocalDate;

import com.duarte.api_livros.entities.Livro;

public record LivroDTO (String titulo,
		String autor,
		String categoria){
		
	public static LivroDTO fromEntity(Livro livro) {
		return new LivroDTO(
				livro.getTitulo(),
				livro.getAutor(),
				livro.getCategoria());
	}
}
