package com.duarte.api_livros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duarte.api_livros.entities.Aluguel;
import com.duarte.api_livros.services.AluguelService;

@RestController
@RequestMapping(value = "/alugueis")
public class AluguelController {
	
	@Autowired
	private AluguelService aluguelService;
	
	@GetMapping
	public ResponseEntity<?> listarAlugueis(){
		return ResponseEntity.ok().body(aluguelService.listarAlugueis());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarAluguel(@PathVariable Long id){
		Aluguel aluguel = aluguelService.buscarAluguel(id);
		
		return ResponseEntity.ok().body(aluguel);
	}
}
