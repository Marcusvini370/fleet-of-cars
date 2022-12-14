package com.br.carmanager.api.assembler;

import com.br.carmanager.api.domain.dto.input.CarroInput;
import com.br.carmanager.api.domain.model.Carro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarroInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Carro toDomainObject(CarroInput carroInput) {
        return modelMapper.map(carroInput, Carro.class);
    }

    public void copyToDomainObject(CarroInput carroInput, Carro carro) {
        modelMapper.map(carroInput, carro);
    }
}
