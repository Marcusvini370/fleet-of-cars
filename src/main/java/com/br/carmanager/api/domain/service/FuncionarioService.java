package com.br.carmanager.api.domain.service;

import com.br.carmanager.api.domain.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {

    Funcionario save(Funcionario funcionario);
    Optional<Funcionario> findById(Long id);
    List<Funcionario> findAll();
    void delete(Long id);
}
