package com.br.carmanager.api.domain.service;


import com.br.carmanager.api.domain.model.Carro;

import java.util.List;

public interface CarroService {

    Carro save(Carro carro);
    Carro findById(Long id);
    List<Carro> findAll();
    void delete(Long id);
    List<Carro> findCarByStatusUnavailable();

}
