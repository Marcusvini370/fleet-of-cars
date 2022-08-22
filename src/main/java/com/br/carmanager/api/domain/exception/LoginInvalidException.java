package com.br.carmanager.api.domain.exception;

public class LoginInvalidException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public LoginInvalidException(String mensagem) {
		super(mensagem);
	}
	
}