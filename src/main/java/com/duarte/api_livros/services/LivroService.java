package com.duarte.api_livros.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duarte.api_livros.entities.Livro;
import com.duarte.api_livros.exceptions.BibliotecaException;
import com.duarte.api_livros.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	//Methods
	public void adicionarLivro(Livro livro) {
		validarDados(livro);
		livroRepository.save(livro);
	}
	
	public void deletarLivro(Long id) {
		Optional<Livro> livroExistente = livroRepository.findById(id);
		
		if(!livroExistente.isPresent()) {
			throw new BibliotecaException("Livro com ID " + id + " não foi encontrado");
		}
		
		livroRepository.deleteById(id);
	}
	
	public Livro buscarLivro(Long id) {
		return livroRepository.findById(id)
				.orElseThrow(() -> new BibliotecaException("Livro com id " + id + " não encontrado."));
	}
	
	public Livro atualizarLivro(Long id, Livro livroAtualizado) {
		Livro livroExistente = buscarLivro(id);
		
		validarDados(livroAtualizado);
		
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
			throw new BibliotecaException("Nenhum livro encontrado na categoria " + categoria);
		}
		
		return livroRepository.findByCategoria(categoria);
	}
	
	public List<Livro> findByAutor(String autor){
		List<Livro> livros = livroRepository.findByAutor(autor);
		
		if(livros.isEmpty()) {
			throw new BibliotecaException("Nenhum livro do autor " + autor);
		}
		
		return livros;
	}
	
	public List<Livro> listarLivros(){
		List<Livro> livros = livroRepository.findAll();
		
		if(livros.isEmpty()) {
			throw new BibliotecaException("A Biblioteca não tem nenhum livro.");
		}
		return livros;
	}
	
	private void validarDados(Livro livro) {
		if(livro.getTitulo().isEmpty()) {
			throw new BibliotecaException("Título não pode ser nulo ou vazio.");
		}
		if(livro.getAutor().isEmpty()) {
			throw new BibliotecaException("Autor não pode ser nulo ou vazio.");
		}
		if(livro.getAnoFabricacao().isAfter(LocalDate.now())) {
			throw new BibliotecaException("Data não pode ser posterior a data atual");
		}
		if(livro.getAnoFabricacao().isBefore(LocalDate.of(1900, 1, 1))) {
			throw new BibliotecaException("O ano de fabricação não pode ser anterior a 1900.");
		}
		if(livro.getCategoria().isEmpty()) {
			throw new BibliotecaException("Categoria não pode ser nula ou vazia.");
		}
		if(livro.getDisponibilidade().isEmpty()) {
			throw new BibliotecaException("Disponibilidade não pode ser nula ou vazia.");
		}
		
	}
	
}
