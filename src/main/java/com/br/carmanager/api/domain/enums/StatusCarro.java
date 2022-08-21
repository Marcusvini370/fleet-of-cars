package com.br.carmanager.api.domain.enums;

public enum StatusCarro {

    DISPONIVEL("Disponível"),
    INDISPONIVEL("Indisponível");

    private String status;

    StatusCarro(String string){
        this.status = string;
    }
}
