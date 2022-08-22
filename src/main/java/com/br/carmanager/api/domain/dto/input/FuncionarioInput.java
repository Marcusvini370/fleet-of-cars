package com.br.carmanager.api.domain.dto.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FuncionarioInput {

    @NotBlank
    @ApiModelProperty(example = "Beatriz Carmadungas", required = true)
    private String nome;

    @NotNull
    @ApiModelProperty(example = "15182", required = true)
    private Integer matricula;

    @NotBlank
    @ApiModelProperty(example = "beamadung", required = true)
    private String login;

    @NotBlank
    @ApiModelProperty(example = "293hd28h@82Wqhsd", required = true)
    private String password;
}
