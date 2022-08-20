package com.br.carmanager.api.domain.service;

import com.br.carmanager.api.domain.model.Viagem;

import java.util.Optional;

public interface ViagemService {

    Viagem save(Viagem viagem);
    Optional<Viagem> findById(Long id);
    void delete(Long id);
}
