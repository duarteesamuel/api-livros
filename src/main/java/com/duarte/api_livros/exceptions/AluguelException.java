package com.duarte.api_livros.exceptions;

public class AluguelException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AluguelException(String msg) {
		super(msg);
	}

}
