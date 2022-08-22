package com.br.carmanager.api.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ViagemDTO {

    @ApiModelProperty(example = "1")
    private Long id;

    private FuncionarioDTO funcionario;

    private CarroDTO carro;

    @ApiModelProperty(example = "2022-08-21T22:49:05.630-03:00")
    private OffsetDateTime dataRetirada;

    @ApiModelProperty(example = "2022-08-22T18:40:05.630-03:00")
    private OffsetDateTime  dataEntrega;
}
