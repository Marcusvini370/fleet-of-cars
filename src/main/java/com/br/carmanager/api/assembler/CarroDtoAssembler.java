package com.br.carmanager.api.assembler;

import com.br.carmanager.api.domain.dto.CarroDTO;
import com.br.carmanager.api.domain.model.Carro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarroDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CarroDTO toModel(Carro carro) {
        return modelMapper.map(carro, CarroDTO.class);
    }

    public List<CarroDTO> toCollectionModel(List<Carro> Carros) {
        return Carros.stream()
                .map(carro -> toModel(carro))
                .collect(Collectors.toList());
    }
}
