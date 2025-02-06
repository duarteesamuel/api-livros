package com.duarte.api_livros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duarte.api_livros.entities.Livro;
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
		livroRepository.deleteById(id);
	}
	
	public Livro buscarLivro(Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		
		return livro.get();
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
		return livroRepository.findByCategoria(categoria);
	}
	
	public List<Livro> listarLivros(){
		return livroRepository.findAll();
	}
	
}
