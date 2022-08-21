package com.br.carmanager.api.domain.enums;

public enum StatusViagem {

    EM_ANDAMENTO("Em andamento"),
    FINALIZADA("Finalizada");

    private String status;

    StatusViagem(String string){
        this.status = string;
    }
}
