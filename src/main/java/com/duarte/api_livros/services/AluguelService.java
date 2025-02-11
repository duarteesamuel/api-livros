package com.duarte.api_livros.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duarte.api_livros.dtos.AluguelDTO;
import com.duarte.api_livros.entities.Aluguel;
import com.duarte.api_livros.exceptions.AluguelException;
import com.duarte.api_livros.repositories.AluguelRepository;

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
	
	public Aluguel buscarAluguel(Long id) {
		return aluguelRepository.findById(id)
				.orElseThrow(() -> new AluguelException("Nenhum aluguel correspondente ao id " + id));
		
	}
}
