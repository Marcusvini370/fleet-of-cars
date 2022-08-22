package com.br.carmanager.api.domain.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FuncionarioInput {

    @NotBlank
    private String nome;

    @NotNull
    private Integer matricula;

    @NotBlank
    private String login;

    @NotBlank
    private String password;
}
