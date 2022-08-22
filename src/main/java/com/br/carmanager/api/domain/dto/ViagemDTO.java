package com.br.carmanager.api.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class ViagemDTO {

    private Long id;
    private FuncionarioDTO funcionario;
    private CarroDTO carro;
    private OffsetDateTime dataRetirada;
    private OffsetDateTime  dataEntrega;
}
