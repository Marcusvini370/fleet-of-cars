package com.br.carmanager.api.assembler;

import com.br.carmanager.api.domain.dto.FuncionarioDTO;
import com.br.carmanager.api.domain.dto.ViagemDTO;
import com.br.carmanager.api.domain.model.Funcionario;
import com.br.carmanager.api.domain.model.Viagem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ViagemDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public ViagemDTO toModel(Viagem viagem) {
        return modelMapper.map(viagem, ViagemDTO.class);
    }

    public List<ViagemDTO> toCollectionModel(List<Viagem> Viagens) {
        return Viagens.stream()
                .map(viagem -> toModel(viagem))
                .collect(Collectors.toList());
    }
}
