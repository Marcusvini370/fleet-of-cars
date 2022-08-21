package com.br.carmanager.api.domain.service;

import com.br.carmanager.api.domain.model.Viagem;

public interface ViagemService {

    Viagem save(Viagem viagem, Long idFuncionario, Long idCarro);
    Viagem findById(Long idViagem);
    void delete(Long idViagem);
}
