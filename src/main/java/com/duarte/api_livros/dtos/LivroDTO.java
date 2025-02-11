package com.duarte.api_livros.dtos;

import com.duarte.api_livros.entities.Livro;
import com.fasterxml.jackson.annotation.JsonProperty;

public record LivroDTO(
	    @JsonProperty("id") Long id,
	    @JsonProperty("titulo") String titulo,
	    @JsonProperty("categoria") String categoria) {

	    public static LivroDTO fromEntity(Livro livro) {
	        return new LivroDTO(
	            livro.getId(),
	            livro.getTitulo(),
	            livro.getCategoria());
	    }
	}
