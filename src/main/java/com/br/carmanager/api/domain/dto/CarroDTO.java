package com.br.carmanager.api.domain.dto;

import com.br.carmanager.api.domain.enums.StatusCarro;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class CarroDTO {

    @ApiModelProperty(example = "1")
    private Long id;

    @ApiModelProperty(example = "Conversível")
    private String modelo;

    @ApiModelProperty(example = "BMW")
    private String marca;

    @ApiModelProperty(example = "2022-08-22T22:49:05.630-03:00")
    private OffsetDateTime dataFabricacao;

    @ApiModelProperty(example = "DISPONIVEL")
    private StatusCarro status;
}
