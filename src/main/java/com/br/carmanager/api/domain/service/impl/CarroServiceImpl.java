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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public CarroDTO save(CarroInput carroInput) {
        Carro carro = carroInputDisassembler.toDomainObject(carroInput);
        return carroDtoAssembler.toModel(carroRepository.save(carro));
    }

    @Override
    @Transactional
    public CarroDTO update(Long id, CarroInput carroInput) {

        Carro carroAtual = BuscarOuFalhar(id);
        carroInputDisassembler.copyToDomainObject(carroInput, carroAtual);

        return carroDtoAssembler.toModel(carroRepository.save(carroAtual));
    }

    @Override
    @Transactional
    public CarroDTO findById(Long id) {
        return carroDtoAssembler.toModel(BuscarOuFalhar(id));
    }

    @Override
    @Transactional
    public List<CarroDTO> findAll() {
        return carroDtoAssembler.toCollectionModel(carroRepository.findAll());
    }

    @Override
    @Transactional
    public Page<CarroDTO> findAllPage(Pageable pageable) {
        Page<Carro> carrosPage = carroRepository.findAll(pageable);
        List<CarroDTO> carrosDTO = carroDtoAssembler.toCollectionModel(carrosPage.getContent());
        Page<CarroDTO> carrosDtoPage = new PageImpl<>(carrosDTO, pageable, carrosPage.getTotalElements());
        return carrosDtoPage;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        BuscarOuFalhar(id);
        try {
            carroRepository.deleteById(id);

        } catch (Exception e) {
            throw new NegocioException(String.format("Não é possível excluir o carro com o código %d", id));
        }
    }

    @Override
    @Transactional
    public List<CarroDTO> findCarByStatusUnavailable() {
        return carroDtoAssembler.toCollectionModel( carroRepository.findCarByStatusUnavailable());
    }

    public Carro BuscarOuFalhar(Long id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new CarroNotFoundException(String.format(MSG_CARRO_NAO_ENCONTRADO, id)));
    }

}
