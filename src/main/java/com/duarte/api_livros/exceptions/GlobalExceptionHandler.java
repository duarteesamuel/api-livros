package com.duarte.api_livros.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BibliotecaException.class)
	public ResponseEntity<?> handleBibliotecaException(BibliotecaException e){
		StringBuilder mensagemErro = new StringBuilder("Erro na biblioteca: ");
		mensagemErro.append(e.getMessage());
		
		return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
	}
	
}
