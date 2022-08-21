package com.br.carmanager.api.domain.dto.input;

import com.br.carmanager.api.domain.enums.StatusCarro;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.OffsetDateTime;

@Getter
@Setter
public class CarroInput {

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca;

    @Column(nullable = false, columnDefinition = "timestamp")
    private OffsetDateTime dataFabricacao;

    private StatusCarro status = StatusCarro.DISPONIVEL;
}
