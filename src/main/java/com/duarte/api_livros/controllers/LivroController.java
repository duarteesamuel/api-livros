package com.duarte.api_livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duarte.api_livros.entities.Livro;
import com.duarte.api_livros.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<Livro>> listarLivros(){
		List<Livro> livros = livroService.findAll();
		
		return ResponseEntity.ok().body(livros);
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
		Livro livro = livroService.findById(id);
		
		return ResponseEntity.ok().body(livro);
	}
	
}
