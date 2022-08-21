package com.br.carmanager.api.domain.dto;

import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.model.Funcionario;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
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
