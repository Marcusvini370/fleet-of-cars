package com.br.carmanager.api.domain.exception;

public class CarroNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public CarroNotFoundException (String mensagem) {
		super(mensagem);
	}
	
}