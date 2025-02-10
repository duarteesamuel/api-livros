package com.duarte.api_livros.entities;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_livros")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "titulo")
	@NotNull(message = "não pode ser nulo.")
	private String titulo;
	
	@Column(name = "autor")
	@NotNull(message = "não pode ser nulo.")
	@Size(min = 3, max = 50, message = "O autor deve ter entre 3 a 50 caracteres.")
	private String autor;
	
	@Column(name = "ano_fabricacao")
	@PastOrPresent(message = "não pode ser maior queo ano atual.")
	private LocalDate anoFabricacao;
	
	@Column(name = "categoria")
	@NotNull(message = "não pode ser nula.")
	private String categoria;
	
	@Column(name = "disponibilidade")
	@NotNull(message = "não pode ser nula.")
	private String disponibilidade;
}
