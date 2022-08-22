package com.br.carmanager.api.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private Integer matricula;
    private String login;
}
