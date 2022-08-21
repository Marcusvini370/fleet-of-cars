package com.br.carmanager.api.assembler;

import com.br.carmanager.api.domain.dto.input.CarroInput;
import com.br.carmanager.api.domain.dto.input.FuncionarioInput;
import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.model.Funcionario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Funcionario toDomainObject(FuncionarioInput funcionarioInput) {
        return modelMapper.map(funcionarioInput, Funcionario.class);
    }

    public void copyToDomainObject(FuncionarioInput funcionarioInput, Funcionario funcionario) {
        modelMapper.map(funcionarioInput, funcionario);
    }
}
