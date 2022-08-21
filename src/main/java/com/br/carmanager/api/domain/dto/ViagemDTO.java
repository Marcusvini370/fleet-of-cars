package com.br.carmanager.api.domain.dto;

import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.model.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ViagemDTO {

    private Long id;
    private Funcionario funcionario;
    private Carro carro;
    private OffsetDateTime dataRetirada;
    private OffsetDateTime  dataEntrega;
}
