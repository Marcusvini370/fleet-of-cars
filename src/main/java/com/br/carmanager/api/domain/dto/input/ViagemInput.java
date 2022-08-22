package com.br.carmanager.api.domain.dto.input;

import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.model.Funcionario;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Setter
@Getter
public class ViagemInput {

    @NotNull
    private Funcionario funcionario;

    @NotNull
    private Carro carro;

    @NotNull
    @ApiModelProperty(example = "2022-08-10T10:00:05.630-03:00", required = true)
    private OffsetDateTime dataRetirada;

    @ApiModelProperty(example = "2022-08-10T15:10:05.630-03:00", required = true)
    private OffsetDateTime dataEntrega;
}
