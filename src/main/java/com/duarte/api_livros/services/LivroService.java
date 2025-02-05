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
	public List<Livro> findAll(){
		return livroRepository.findAll();
	}
	
	public void deletarLivroPorId(Long id) {
		livroRepository.deleteById(id);
	}
	
	public Livro buscarLivroPorId(Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		
		return livro.get();
	}
	
	public Livro atualizarLivro(Long id, Livro livroAtualizado) {
		Livro livroExistente = buscarLivroPorId(id);
		
		livroExistente.setTitulo(livroAtualizado.getTitulo());
		livroExistente.setAutor(livroAtualizado.getAutor());
		livroExistente.setAnoFabricacao(livroAtualizado.getAnoFabricacao());
		livroExistente.setCategoria(livroAtualizado.getCategoria());
		livroExistente.setDisponibilidade(livroAtualizado.getDisponibilidade());
		
		return livroRepository.save(livroExistente);
	}
	
}
