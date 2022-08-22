package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.assembler.CarroDtoAssembler;
import com.br.carmanager.api.assembler.CarroInputDisassembler;
import com.br.carmanager.api.domain.dto.CarroDTO;
import com.br.carmanager.api.domain.dto.input.CarroInput;
import com.br.carmanager.api.domain.exception.CarroNotFoundException;
import com.br.carmanager.api.domain.exception.NegocioException;
import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.repository.CarroRepository;
import com.br.carmanager.api.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

    private static final String MSG_CARRO_NAO_ENCONTRADO = "Não existe um cadastro de carro com o código %d";
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroDtoAssembler carroDtoAssembler;

    @Autowired
    CarroInputDisassembler carroInputDisassembler;

    @Override
    public CarroDTO save(CarroInput carroInput) {
        Carro carro = carroInputDisassembler.toDomainObject(carroInput);
        return carroDtoAssembler.toModel(carroRepository.save(carro));
    }

    @Override
    public CarroDTO update(Long id, CarroInput carroInput) {

        Carro carroAtual = BuscarOuFalhar(id);
        carroInputDisassembler.copyToDomainObject(carroInput, carroAtual);

        return carroDtoAssembler.toModel(carroRepository.save(carroAtual));
    }

    @Override
    public CarroDTO findById(Long id) {
        return carroDtoAssembler.toModel(BuscarOuFalhar(id));
    }

    @Override
    public List<CarroDTO> findAll() {
        return carroDtoAssembler.toCollectionModel(carroRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        BuscarOuFalhar(id);
        try {
            carroRepository.deleteById(id);

        } catch (Exception e) {
            throw new NegocioException(String.format("Não é possível excluir o carro com o código %d", id));
        }
    }

    @Override
    public List<CarroDTO> findCarByStatusUnavailable() {
        return carroDtoAssembler.toCollectionModel( carroRepository.findCarByStatusUnavailable());
    }

    public Carro BuscarOuFalhar(Long id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new CarroNotFoundException(String.format(MSG_CARRO_NAO_ENCONTRADO, id)));
    }

}
