package com.duarte.api_livros.exceptions;


public class BibliotecaException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public BibliotecaException(String msg) {
		super(msg);
	}
	
}
