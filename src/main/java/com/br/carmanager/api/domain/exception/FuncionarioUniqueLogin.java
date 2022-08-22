package com.br.carmanager.api.domain.exception;

public class FuncionarioUniqueLogin extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public FuncionarioUniqueLogin(String mensagem) {
		super(mensagem);
	}
	
}