package com.duarte.api_livros.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duarte.api_livros.entities.Livro;
import com.duarte.api_livros.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping(value = "/adicionar")
	public ResponseEntity<?> adicionarLivro(@RequestBody Livro livro){
		livroService.adicionarLivro(livro);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(livro);
	}
	
	@GetMapping(value = "/listar")
	public ResponseEntity<?> listarLivros(){
		return ResponseEntity.status(HttpStatus.OK).body(livroService.listarLivros());
	}
	
}
