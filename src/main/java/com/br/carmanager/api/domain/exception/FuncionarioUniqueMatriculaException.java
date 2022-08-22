package com.br.carmanager.api.domain.exception;

public class FuncionarioUniqueMatriculaException extends NegocioException {

	private static final long serialVersionUID = 1L;

	public FuncionarioUniqueMatriculaException(String mensagem) {
		super(mensagem);
	}
	
}