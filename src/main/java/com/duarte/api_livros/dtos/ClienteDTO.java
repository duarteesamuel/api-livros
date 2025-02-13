package com.duarte.api_livros.dtos;

import com.duarte.api_livros.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;

public record ClienteDTO(
	    @JsonProperty("nome") String nome,
	    @JsonProperty("cpf") String cpf) {

	    public static ClienteDTO fromEntity(Cliente cliente) {
	        return new ClienteDTO(
	            cliente.getNome(),
	            cliente.getCpf());
	    }
	}
