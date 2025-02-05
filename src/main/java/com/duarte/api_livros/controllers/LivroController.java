package com.duarte.api_livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping(value = "/adicionar")
	public ResponseEntity<?> adicionarLivro(@RequestBody Livro livro){
		
		livroService.adicionarLivro(livro);
		return ResponseEntity.ok().body("Livro cadastrado com sucesso.");
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> buscarLivro(@PathVariable Long id){
		
		Livro livro = livroService.buscarLivro(id);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<?> deletarLivro(@PathVariable Long id){
		
		livroService.deletarLivro(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso.");
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<?> atualizarLivro(@PathVariable Long id,
			@RequestBody Livro livroAtualizado){
		
		Livro livro = livroService.atualizarLivro(id, livroAtualizado);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping(value = "/listar")
	public ResponseEntity<List<?>> listarLivros(){
		
		List<Livro> livros = livroService.listarLivros();
		
		return ResponseEntity.ok().body(livros);
	}
	
	
	
}
