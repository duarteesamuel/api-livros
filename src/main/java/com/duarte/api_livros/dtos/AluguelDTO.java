package com.duarte.api_livros.dtos;

import java.time.LocalDate;

import com.duarte.api_livros.entities.Aluguel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AluguelDTO(
	    @JsonProperty("id") Long id,
	    @JsonProperty("cliente") ClienteDTO cliente,
	    @JsonProperty("livro") LivroDTO livro,
	    @JsonProperty("dataAluguel") @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dataAluguel,
	    @JsonProperty("dataDevolucao") @JsonFormat(pattern = "yyyy-MM-dd") LocalDate dataDevolucao) {

	    // Método estático para mapear a entidade de Aluguel para AluguelDTO
	    public static AluguelDTO fromEntity(Aluguel aluguel) {
	        return new AluguelDTO(
	            aluguel.getId(),
	            ClienteDTO.fromEntity(aluguel.getCliente()), // Converte o cliente para DTO
	            LivroDTO.fromEntity(aluguel.getLivro()),     // Converte o livro para DTO
	            aluguel.getDataAluguel(),
	            aluguel.getDataDevolucao());
	    }
	}
