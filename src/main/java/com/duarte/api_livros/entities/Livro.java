package com.duarte.api_livros.entities;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Livro {
	
	private String titulo;
	private String autor;
	private LocalDate anoFabricacao;
	private String categoria;
	private String disponibilidade;
}
