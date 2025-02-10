package com.duarte.api_livros.controllers;

import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duarte.api_livros.dtos.LivroDTO;
import com.duarte.api_livros.entities.Livro;
import com.duarte.api_livros.services.LivroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public ResponseEntity<?> adicionarLivro(@Valid @RequestBody Livro livro){
		
		livroService.adicionarLivro(livro);
		return ResponseEntity.ok().body("Livro cadastrado com sucesso.");
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarLivro(@PathVariable Long id){
		
		Livro livro = livroService.buscarLivro(id);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletarLivro(@PathVariable Long id){
		
		livroService.deletarLivro(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso.");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarLivro(@PathVariable Long id,
			@Valid @RequestBody Livro livroAtualizado){
		
		Livro livro = livroService.atualizarLivro(id, livroAtualizado);
		
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping(params = "categoria")
	public ResponseEntity<?> buscarLivroPorCategoria(@RequestParam String categoria){
		 List<Livro> livros = livroService.findByCategoria(categoria);
		 
		 return ResponseEntity.ok().body(livros);
	}
	
	@GetMapping(params = "autor")
	public ResponseEntity<?> buscarLivroPorAutor(@RequestParam String autor){
		List<Livro> livros = livroService.findByAutor(autor);
		
		return ResponseEntity.ok().body(livros);
	}
	
	@GetMapping
	public ResponseEntity<?> listarLivros(){
		
		List<Livro> livros = livroService.listarLivros();
		
		List<LivroDTO> livrosDTO = livros.stream()
				.map(LivroDTO::fromEntity)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(livrosDTO);
		
	}
}
