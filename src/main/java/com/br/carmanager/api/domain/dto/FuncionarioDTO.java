package com.br.carmanager.api.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO {

    @ApiModelProperty(example = "1")
    private Long id;

    @ApiModelProperty(example = "Marcus Vinicius")
    private String nome;

    @ApiModelProperty(example = "10232")
    private Integer matricula;

    @ApiModelProperty(example = "marvin22")
    private String login;
}
