package com.br.carmanager.api.domain.service;


import com.br.carmanager.api.domain.dto.CarroDTO;
import com.br.carmanager.api.domain.dto.input.CarroInput;
import com.br.carmanager.api.domain.model.Carro;

import java.util.List;

public interface CarroService {

    CarroDTO save(CarroInput carroInput);
    CarroDTO findById(Long id);
    List<CarroDTO> findAll();
    void delete(Long id);
    List<CarroDTO> findCarByStatusUnavailable();

}
