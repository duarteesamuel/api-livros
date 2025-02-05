package com.duarte.api_livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<?>> listarLivros(){
		
		List<Livro> livros = livroService.findAll();
		
		return ResponseEntity.ok().body(livros);
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		
		Livro livro = livroService.buscarLivroPorId(id);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<?> deletarPorId(@PathVariable Long id){
		
		livroService.deletarLivroPorId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso.");
	}
	
	
	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<?> atualizarLivroPorId(@PathVariable Long id,
			@RequestBody Livro livroAtualizado){
		
		Livro livro = livroService.atualizarLivro(id, livroAtualizado);
		
		return ResponseEntity.ok().body(livro);
	}
	
	
	
}
