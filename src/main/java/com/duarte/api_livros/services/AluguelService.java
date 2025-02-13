package com.duarte.api_livros.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duarte.api_livros.dtos.AluguelDTO;
import com.duarte.api_livros.entities.Aluguel;
import com.duarte.api_livros.entities.Cliente;
import com.duarte.api_livros.entities.Livro;
import com.duarte.api_livros.exceptions.AluguelException;
import com.duarte.api_livros.exceptions.ClienteException;
import com.duarte.api_livros.exceptions.LivroException;
import com.duarte.api_livros.repositories.AluguelRepository;
import com.duarte.api_livros.repositories.ClienteRepository;
import com.duarte.api_livros.repositories.LivroRepository;

@Service
public class AluguelService {
	
	
	@Autowired
	private AluguelRepository aluguelRepository;
	
	
	public List<AluguelDTO> listarAlugueis(){
		List<Aluguel> alugueis = aluguelRepository.findAll();
		
		if(alugueis.isEmpty()) {
			throw new AluguelException("Nenhum aluguel encontrado.");
		}
		
		return alugueis.stream()
				.map(AluguelDTO::fromEntity)
				.collect(Collectors.toList());
	}
	
	public List<Aluguel> buscarAlugueisPorCliente(Long clienteId) {
	    List<Aluguel> alugueis = aluguelRepository.findByClienteId(clienteId);
	    if (alugueis.isEmpty()) {
	        throw new AluguelException("Nenhum aluguel encontrado para o cliente com id " + clienteId);
	    }
	    return alugueis;
	}

}

