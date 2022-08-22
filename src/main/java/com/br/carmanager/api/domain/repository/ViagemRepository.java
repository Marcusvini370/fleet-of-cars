package com.br.carmanager.api.domain.repository;

import com.br.carmanager.api.domain.dto.ViagemDTO;
import com.br.carmanager.api.domain.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    @Query(value = "SELECT v.* FROM tb_viagem v WHERE extract(month from v.data_entrega) = :month and extract" +
            " (year from v.data_entrega) = :year and v.data_entrega IS NOT NULL", nativeQuery = true)
    List<Viagem> findViagemByDataEntregaWithMonthAndYear(Integer month, Integer year);

    @Query("Select v from Viagem v where v.funcionario.id = :idFuncionario and v.carro.id = :idCarro and v.dataEntrega = null")
    Viagem findViagemByFuncionarioWithCarInUse(Long idFuncionario, Long idCarro);

    List<Viagem> findViagemByFuncionarioIdAndCarroId(Long idFuncionario, Long idCarro);

}
