package com.duarte.api_livros.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LivroException.class)
	public ResponseEntity<?> handleBibliotecaException(LivroException e){
		StringBuilder mensagemErro = new StringBuilder("Erro na biblioteca: ");
		mensagemErro.append(e.getMessage());
		
		return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ClienteException.class)
	public ResponseEntity<?> handleClienteException(ClienteException e){
		StringBuilder mensagemErro = new StringBuilder("Erro no cliente: ");
		mensagemErro.append(e.getMessage());
		
		return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
	}
	
}
