package com.br.carmanager.api.domain.service;

import com.br.carmanager.api.domain.model.Viagem;

import java.util.List;

public interface ViagemService {

    Viagem save(Viagem viagem, Long idFuncionario, Long idCarro);
    Viagem findById(Long idViagem);
    void delete(Long idFuncionario, Long idCarro);
    List<Viagem> findViagemByDataEntregaWithMonthAndYear(Integer month, Integer year);

}
