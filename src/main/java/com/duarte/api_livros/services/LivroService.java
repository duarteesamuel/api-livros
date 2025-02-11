package com.duarte.api_livros.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duarte.api_livros.entities.Livro;
import com.duarte.api_livros.exceptions.LivroException;
import com.duarte.api_livros.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	//Methods
	public void adicionarLivro(Livro livro) {
		livroRepository.save(livro);
	}
	
	public void deletarLivro(Long id) {
		Optional<Livro> livroExistente = livroRepository.findById(id);
		
		if(!livroExistente.isPresent()) {
			throw new LivroException("Livro com ID " + id + " não foi encontrado");
		}
		
		livroRepository.deleteById(id);
	}
	
	public Livro buscarLivro(Long id) {
		return livroRepository.findById(id)
				.orElseThrow(() -> new LivroException("Livro com id " + id + " não encontrado."));
	}
	
	public Livro atualizarLivro(Long id, Livro livroAtualizado) {
		Livro livroExistente = buscarLivro(id);
		
		livroExistente.setTitulo(livroAtualizado.getTitulo());
		livroExistente.setAutor(livroAtualizado.getAutor());
		livroExistente.setAnoFabricacao(livroAtualizado.getAnoFabricacao());
		livroExistente.setCategoria(livroAtualizado.getCategoria());
		livroExistente.setDisponibilidade(livroAtualizado.getDisponibilidade());
		
		return livroRepository.save(livroExistente);
	}
	
	public List<Livro> findByCategoria(String categoria){
		List<Livro> livros = livroRepository.findByCategoria(categoria);
		
		if(livros.isEmpty()) {
			throw new LivroException("Nenhum livro encontrado na categoria " + categoria);
		}
		
		return livroRepository.findByCategoria(categoria);
	}
	
	public List<Livro> findByAutor(String autor){
		List<Livro> livros = livroRepository.findByAutor(autor);
		
		if(livros.isEmpty()) {
			throw new LivroException("Nenhum livro do autor " + autor);
		}
		
		return livros;
	}
	
	public List<Livro> listarLivros(){
		List<Livro> livros = livroRepository.findAll();
		
		if(livros.isEmpty()) {
			throw new LivroException("A Biblioteca não tem nenhum livro.");
		}
		return livros;
	}
	
	
}
