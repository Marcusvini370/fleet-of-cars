package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.assembler.FuncionarioDtoAssembler;
import com.br.carmanager.api.assembler.FuncionarioInputDisassembler;
import com.br.carmanager.api.domain.dto.FuncionarioDTO;
import com.br.carmanager.api.domain.dto.input.FuncionarioInput;
import com.br.carmanager.api.domain.exception.FuncionarioNotFoundException;
import com.br.carmanager.api.domain.exception.FuncionarioUniqueLogin;
import com.br.carmanager.api.domain.exception.FuncionarioUniqueMatriculaException;
import com.br.carmanager.api.domain.model.Funcionario;
import com.br.carmanager.api.domain.repository.FuncionarioRepository;
import com.br.carmanager.api.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private static final String MSG_FUNCIONARIO_NAO_ENCONTRADO = "Não existe um cadastro de funcionário com o código %d";
    private static final String MSG_FUNCIONARIO_LOGIN_UNICO = "Já existe um cadastro de funcionário com o login %s ";
    private static final String MSG_FUNCIONARIO_MATRICULA_UNICA = "A matrícula %d já está sendo utilizada por outro funcionário";

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioDtoAssembler funcionarioDtoAssembler;

    @Autowired
    private FuncionarioInputDisassembler funcionarioInputDisassembler;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public FuncionarioDTO save(FuncionarioInput funcionarioInput) {
        Funcionario funcionario = funcionarioInputDisassembler.toDomainObject(funcionarioInput);

        if (funcionarioRepository.findByMatricula(funcionario.getMatricula()) != null) {
            throw new FuncionarioUniqueMatriculaException(String.format(MSG_FUNCIONARIO_MATRICULA_UNICA, funcionario.getMatricula()));
        }

        if (funcionarioRepository.findFuncionarioByLogin(funcionario.getLogin()) != null) {
            throw new FuncionarioUniqueLogin(String.format(MSG_FUNCIONARIO_LOGIN_UNICO, funcionario.getLogin()));
        }

        funcionario.setPassword(this.bCryptPasswordEncoder.encode(funcionarioInput.getPassword()));
        return funcionarioDtoAssembler.toModel(funcionarioRepository.save(funcionario));
    }

    @Override
    public FuncionarioDTO findById(Long id) {
        return funcionarioDtoAssembler.toModel(BuscarOuFalhar(id));
    }

    @Override
    public List<FuncionarioDTO> findAll() {
        return funcionarioDtoAssembler.toCollectionModel(funcionarioRepository.findAll());
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
