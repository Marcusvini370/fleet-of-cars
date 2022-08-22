package com.br.carmanager.api.domain.repository;

import com.br.carmanager.api.domain.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByLogin(String login);
    Funcionario findFuncionarioByLogin(String login);

    Funcionario findByMatricula(Integer matricula);
}
