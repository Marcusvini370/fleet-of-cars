package com.br.carmanager.api.domain.dto.input;

import com.br.carmanager.api.domain.enums.StatusCarro;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Getter
@Setter
public class CarroInput {

    @NotBlank
    @ApiModelProperty(example = "Esportivo", required = true)
    private String modelo;

    @NotBlank
    @ApiModelProperty(example = "Ford", required = true)
    private String marca;

    @NotNull
    @ApiModelProperty(example = "2022-01-01T10:00:05.630-03:00", required = true)
    private OffsetDateTime dataFabricacao;

    @ApiModelProperty(example = "INDISPONIVEL", required = true)
    private StatusCarro status = StatusCarro.DISPONIVEL;
}
