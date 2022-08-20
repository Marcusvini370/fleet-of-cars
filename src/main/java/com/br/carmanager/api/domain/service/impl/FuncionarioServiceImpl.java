package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.domain.model.Funcionario;
import com.br.carmanager.api.domain.repository.FuncionarioRepository;
import com.br.carmanager.api.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> findById(Long id) {
        return funcionarioRepository.findById(id);
    }

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
