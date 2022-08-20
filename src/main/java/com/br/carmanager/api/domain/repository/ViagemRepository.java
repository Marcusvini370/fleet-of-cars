package com.br.carmanager.api.domain.repository;

import com.br.carmanager.api.domain.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
}
