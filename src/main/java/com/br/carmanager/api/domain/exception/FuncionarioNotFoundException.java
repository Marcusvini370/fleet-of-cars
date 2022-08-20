package com.br.carmanager.api.domain.exception;

public class FuncionarioNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public FuncionarioNotFoundException (String mensagem) {
		super(mensagem);
	}
	
}