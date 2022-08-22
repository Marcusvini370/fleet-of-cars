package com.br.carmanager.api.domain.service;


import com.br.carmanager.api.domain.dto.CarroDTO;
import com.br.carmanager.api.domain.dto.input.CarroInput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarroService {

    CarroDTO save(CarroInput carroInput);
    CarroDTO update(Long id, CarroInput carroInput);
    CarroDTO findById(Long id);
    List<CarroDTO> findAll();
    Page<CarroDTO> findAllPage(Pageable pageable);
    void delete(Long id);
    List<CarroDTO> findCarByStatusUnavailable();

}
