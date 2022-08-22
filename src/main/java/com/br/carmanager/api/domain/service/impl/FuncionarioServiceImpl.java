package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.assembler.FuncionarioDtoAssembler;
import com.br.carmanager.api.assembler.FuncionarioInputDisassembler;
import com.br.carmanager.api.domain.dto.FuncionarioDTO;
import com.br.carmanager.api.domain.dto.input.FuncionarioInput;
import com.br.carmanager.api.domain.exception.FuncionarioNotFoundException;
import com.br.carmanager.api.domain.exception.FuncionarioUniqueLogin;
import com.br.carmanager.api.domain.exception.FuncionarioUniqueMatriculaException;
import com.br.carmanager.api.domain.exception.NegocioException;
import com.br.carmanager.api.domain.model.Funcionario;
import com.br.carmanager.api.domain.repository.FuncionarioRepository;
import com.br.carmanager.api.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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
    @Transactional
    public FuncionarioDTO update(Long id, FuncionarioInput funcionarioInput) {

        Funcionario funcionarioAtual = BuscarOuFalhar(id);
        funcionarioInputDisassembler.copyToDomainObject(funcionarioInput, funcionarioAtual);

        if (funcionarioInput.getLogin() != funcionarioAtual.getLogin()) {
            if (funcionarioRepository.findFuncionarioByLogin(funcionarioAtual.getLogin()) != null) {
                throw new FuncionarioUniqueLogin(String.format(MSG_FUNCIONARIO_LOGIN_UNICO, funcionarioAtual.getLogin()));
            }
        }

        if (funcionarioInput.getMatricula() != funcionarioAtual.getMatricula()) {
            if (funcionarioRepository.findByMatricula(funcionarioAtual.getMatricula()) != null) {
                throw new FuncionarioUniqueMatriculaException(String.format(MSG_FUNCIONARIO_MATRICULA_UNICA, funcionarioAtual.getMatricula()));
            }
        }

        funcionarioAtual.setPassword(this.bCryptPasswordEncoder.encode(funcionarioAtual .getPassword()));

        return funcionarioDtoAssembler.toModel(funcionarioRepository.save(funcionarioAtual));
    }

    @Override
    @Transactional
    public FuncionarioDTO findById(Long id) {
        return funcionarioDtoAssembler.toModel(BuscarOuFalhar(id));
    }

    @Override
    @Transactional
    public Page<FuncionarioDTO> findAllPage(Pageable pageable) {
        Page<Funcionario> funcionariosPage = funcionarioRepository.findAll(pageable);
        List<FuncionarioDTO> funcionariosDTO = funcionarioDtoAssembler.toCollectionModel(funcionariosPage.getContent());
        Page<FuncionarioDTO> funcionariosDtoPage = new PageImpl<>(funcionariosDTO, pageable, funcionariosPage.getTotalElements());
        return funcionariosDtoPage;
    }

    @Override
    public List<FuncionarioDTO> findAll() {
        return funcionarioDtoAssembler.toCollectionModel(funcionarioRepository.findAll());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        try {
            BuscarOuFalhar(id);
            funcionarioRepository.deleteById(id);

        } catch (Exception e) {
            throw new NegocioException(String.format("Não é possível excluir o funcionário com o código %d", id));
        }
    }

    public Funcionario BuscarOuFalhar(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(String.format(MSG_FUNCIONARIO_NAO_ENCONTRADO, id)));
    }
}
