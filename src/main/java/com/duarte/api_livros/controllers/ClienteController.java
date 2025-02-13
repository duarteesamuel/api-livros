package com.duarte.api_livros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duarte.api_livros.entities.Cliente;
import com.duarte.api_livros.exceptions.ClienteException;
import com.duarte.api_livros.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping
	public ResponseEntity<?> cadastrarCliente(@Valid @RequestBody Cliente cliente){
			clienteService.cadastrarCliente(cliente);
			return ResponseEntity.ok().body("Cliente cadastrado com sucesso.");
			
	}
	
	
	@GetMapping
	public ResponseEntity<?> listarClientes(){
		
		return ResponseEntity.ok()
			.body(clienteService.listarClientes());
	}
}
