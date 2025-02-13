package com.duarte.api_livros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGetAllExceptions(Exception e){
		return processarErros(e);
	}

	
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
	
	@ExceptionHandler(AluguelException.class)
	public ResponseEntity<?> handleAluguelException(AluguelException e){
		StringBuilder mensagemErro = new StringBuilder("Erro no aluguel: ");
		mensagemErro.append(e.getMessage());
		
		return new ResponseEntity<>(mensagemErro, HttpStatus.BAD_REQUEST);
	}
	
	//Processar os erros
	private ResponseEntity<?> processarErros(Exception exception){
		StringBuilder mensagemErro = new StringBuilder();
		
		if (exception instanceof LivroException) {
            mensagemErro.append("Erro na biblioteca: ").append(exception.getMessage());
        } else if (exception instanceof ClienteException) {
            mensagemErro.append("Erro no cliente: ").append(exception.getMessage());
        } else if (exception instanceof AluguelException) {
            mensagemErro.append("Erro no aluguel: ").append(exception.getMessage());
        } else {
            mensagemErro.append("Erro desconhecido: ").append(exception.getMessage());
        }
		
		return new ResponseEntity<>(mensagemErro.toString(), HttpStatus.BAD_REQUEST);
	}
	
}
