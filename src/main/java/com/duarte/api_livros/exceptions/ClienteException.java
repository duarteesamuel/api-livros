package com.duarte.api_livros.exceptions;

public class ClienteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ClienteException(String msg) {
		super(msg);
	}

}
