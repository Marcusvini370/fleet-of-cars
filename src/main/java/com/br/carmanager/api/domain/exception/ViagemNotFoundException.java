package com.br.carmanager.api.domain.exception;

public class ViagemNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public ViagemNotFoundException (String mensagem) {
		super(mensagem);
	}
	
}