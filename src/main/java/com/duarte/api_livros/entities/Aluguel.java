package com.duarte.api_livros.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_aluguel_livro")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Aluguel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluguel")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente",
	referencedColumnName = "id_cliente",
	nullable = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_livro",
	referencedColumnName = "id_livro",
	nullable = false)
	private Livro livro;
	
	@Column(name = "data_aluguel")
	@PastOrPresent(message = "Data não pode ser posterior a data atual.")
	private LocalDate dataAluguel;
	
	@Column(name = "data_devolucao")
	private LocalDate dataDevolucao;
}
