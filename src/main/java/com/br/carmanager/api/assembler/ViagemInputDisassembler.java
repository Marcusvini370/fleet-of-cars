package com.br.carmanager.api.assembler;

import com.br.carmanager.api.domain.dto.input.ViagemInput;
import com.br.carmanager.api.domain.model.Viagem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ViagemInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Viagem toDomainObject(ViagemInput viagemInput) {
        return modelMapper.map(viagemInput, Viagem.class);
    }

    public void copyToDomainObject(ViagemInput viagemInput, Viagem viagem) {
        modelMapper.map(viagemInput, viagem);
    }
}
