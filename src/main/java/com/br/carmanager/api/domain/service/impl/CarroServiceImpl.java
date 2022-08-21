package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.domain.exception.CarroNotFoundException;
import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.repository.CarroRepository;
import com.br.carmanager.api.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

    private static final String MSG_CARRO_NAO_ENCONTRADO = "Não existe um cadastro de carro com o código %d";
    @Autowired
    private CarroRepository carroRepository;

    @Override
    public Carro save(Carro carro) {
        return carroRepository.save(carro);
    }

    @Override
    public Carro findById(Long id) {
        return BuscarOuFalhar(id);
    }

    @Override
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    @Override
    public void delete(Long id) {

        try {
            carroRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new CarroNotFoundException(String.format(MSG_CARRO_NAO_ENCONTRADO, id));
        }
    }

    @Override
    public List<Carro> findCarByStatusUnavailable() {
        return carroRepository.findCarByStatusUnavailable();
    }

    public Carro BuscarOuFalhar(Long id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new CarroNotFoundException(String.format(MSG_CARRO_NAO_ENCONTRADO, id)));
    }

}
