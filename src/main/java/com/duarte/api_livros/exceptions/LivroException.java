package com.duarte.api_livros.exceptions;


public class LivroException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public LivroException(String msg) {
		super(msg);
	}
	
}
