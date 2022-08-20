package com.br.carmanager.api.domain.exception;

public class EntityNotFoundException extends NegocioException{
	
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String mensagem) {
		super(mensagem);
	}

}