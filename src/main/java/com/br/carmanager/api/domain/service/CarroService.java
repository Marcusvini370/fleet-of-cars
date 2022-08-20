package com.br.carmanager.api.domain.service;


import com.br.carmanager.api.domain.model.Carro;

import java.util.List;
import java.util.Optional;

public interface CarroService {

    Carro save(Carro carro);
    Optional<Carro> findById(Long id);
    List<Carro> findAll();
    void delete(Long id);
}
