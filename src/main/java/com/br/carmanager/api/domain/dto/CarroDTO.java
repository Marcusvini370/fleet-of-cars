package com.br.carmanager.api.domain.dto;

import com.br.carmanager.api.domain.enums.StatusCarro;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
public class CarroDTO {

    private Long id;
    private String modelo;
    private String marca;
    private OffsetDateTime dataFabricacao;
    private StatusCarro status;
}
