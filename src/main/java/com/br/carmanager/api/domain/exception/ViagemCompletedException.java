package com.br.carmanager.api.domain.exception;

public class ViagemCompletedException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public ViagemCompletedException(String mensagem) {
		super(mensagem);
	}
	
}