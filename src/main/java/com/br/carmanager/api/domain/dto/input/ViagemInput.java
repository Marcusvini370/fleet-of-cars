package com.br.carmanager.api.domain.dto.input;

import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.model.Funcionario;
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
    private OffsetDateTime dataRetirada;

    private OffsetDateTime dataEntrega;
}
