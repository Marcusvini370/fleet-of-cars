package com.br.carmanager.api.domain.service;

import com.br.carmanager.api.domain.dto.FuncionarioDTO;
import com.br.carmanager.api.domain.dto.input.FuncionarioInput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FuncionarioService {

    FuncionarioDTO save(FuncionarioInput funcionarioInput);
    FuncionarioDTO update(Long id, FuncionarioInput funcionarioInput);
    FuncionarioDTO findById(Long id);
    List<FuncionarioDTO> findAll();
    Page<FuncionarioDTO> findAllPage(Pageable pageable);
    void delete(Long id);
}
