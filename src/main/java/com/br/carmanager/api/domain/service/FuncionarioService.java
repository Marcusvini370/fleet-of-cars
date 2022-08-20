package com.br.carmanager.api.domain.service;

import com.br.carmanager.api.domain.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    Funcionario save(Funcionario funcionario);
    Funcionario findById(Long id);
    List<Funcionario> findAll();
    void delete(Long id);
}
