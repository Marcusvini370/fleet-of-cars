package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.domain.exception.CarroNotFoundException;
import com.br.carmanager.api.domain.exception.FuncionarioNotFoundException;
import com.br.carmanager.api.domain.model.Funcionario;
import com.br.carmanager.api.domain.repository.FuncionarioRepository;
import com.br.carmanager.api.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private static final String MSG_FUNCIONARIO_NAO_ENCONTRADO = "Não existe um cadastro de funcionário com o código %d";

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario findById(Long id) {
        return BuscarOuFalhar(id);
    }

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public void delete(Long id) {

        try {
            funcionarioRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new FuncionarioNotFoundException(String.format(MSG_FUNCIONARIO_NAO_ENCONTRADO, id));
        }
    }

    public Funcionario BuscarOuFalhar(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(String.format(MSG_FUNCIONARIO_NAO_ENCONTRADO, id)));
    }
}
