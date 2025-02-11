package com.duarte.api_livros.entities;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_livros")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	@NotBlank(message = "Título não pode ser vazio.")
	private String titulo;
	
	@Column(name = "autor")
	@NotBlank(message = "Autor não pode ser vazio.")
	private String autor;
	
	@Column(name = "ano_fabricacao")
	@PastOrPresent(message = "Data não pode ser posterior a data atual.")
	private LocalDate anoFabricacao;
	
	@Column(name = "categoria")
	@NotBlank(message = "Categoria não pode ser vazia.")
	private String categoria;
	
	@Column(name = "disponibilidade")
	@NotBlank(message = "Disponibilidade não pode ser nula.")
	private String disponibilidade;
}
