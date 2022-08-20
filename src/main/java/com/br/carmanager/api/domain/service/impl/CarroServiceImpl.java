package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.repository.CarroRepository;
import com.br.carmanager.api.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public Carro save(Carro carro) {
        return carroRepository.save(carro);
    }

    @Override
    public Optional<Carro> findById(Long id) {
        return carroRepository.findById(id);
    }

    @Override
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        carroRepository.deleteById(id);
    }
}
