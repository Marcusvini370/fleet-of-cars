package com.br.carmanager.api.domain.model;


import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_viagem")
public class Viagem implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private Carro carro;

    private Date dataRetirada;
    private Date dataEntrega;

}
