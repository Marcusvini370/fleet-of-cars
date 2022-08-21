package com.br.carmanager.api.domain.model;

import com.br.carmanager.api.domain.enums.StatusCarro;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_carro")
public class Carro implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelo;

    private String marca;

    private OffsetDateTime dataFabricacao;

    @Enumerated(EnumType.STRING)
    private StatusCarro status;
}
