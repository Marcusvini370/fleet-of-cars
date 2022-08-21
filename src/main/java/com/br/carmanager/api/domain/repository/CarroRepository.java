package com.br.carmanager.api.domain.repository;

import com.br.carmanager.api.domain.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {


    @Query("Select c from Carro c where c.status = 'INDISPONIVEL' ")
    List<Carro> findCarByStatusUnavailable();

}
