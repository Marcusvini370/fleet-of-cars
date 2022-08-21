package com.br.carmanager.api.assembler;

import com.br.carmanager.api.domain.dto.FuncionarioDTO;
import com.br.carmanager.api.domain.model.Funcionario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FuncionarioDtoAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public FuncionarioDTO toModel(Funcionario funcionario) {
        return modelMapper.map(funcionario, FuncionarioDTO.class);
    }

    public List<FuncionarioDTO> toCollectionModel(List<Funcionario> Funcionarios) {
        return Funcionarios.stream()
                .map(funcionario -> toModel(funcionario))
                .collect(Collectors.toList());
    }
}
