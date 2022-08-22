package com.br.carmanager.api.domain.service;

import com.br.carmanager.api.domain.dto.FuncionarioDTO;
import com.br.carmanager.api.domain.dto.input.FuncionarioInput;

import java.util.List;

public interface FuncionarioService {

    FuncionarioDTO save(FuncionarioInput funcionarioInput);
    FuncionarioDTO update(Long id, FuncionarioInput funcionarioInput);
    FuncionarioDTO findById(Long id);
    List<FuncionarioDTO> findAll();
    void delete(Long id);
}
