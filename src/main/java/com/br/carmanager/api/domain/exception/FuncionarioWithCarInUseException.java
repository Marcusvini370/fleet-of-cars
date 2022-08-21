package com.br.carmanager.api.domain.exception;

public class FuncionarioWithCarInUseException extends NegocioException {

    private static final long serialVersionUID = 1L;

    public FuncionarioWithCarInUseException(String mensagem) {
        super(mensagem);
    }
}
