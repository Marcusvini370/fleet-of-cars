package com.br.carmanager.api.domain.service;

import com.br.carmanager.api.domain.model.Viagem;
import com.br.carmanager.api.domain.repository.ViagemRepository;

import java.util.Optional;

public interface ViagemService {

    Viagem save(Viagem viagem);
    Optional<ViagemRepository> findById(Long id);
    void delete(Long id);
}
