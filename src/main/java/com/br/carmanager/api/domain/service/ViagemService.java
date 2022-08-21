package com.br.carmanager.api.domain.service;

import com.br.carmanager.api.domain.dto.ViagemDTO;
import com.br.carmanager.api.domain.dto.input.ViagemInput;
import com.br.carmanager.api.domain.model.Viagem;

import java.util.List;

public interface ViagemService {

    ViagemDTO save(ViagemInput viagemInput, Long idFuncionario, Long idCarro);
    ViagemDTO findById(Long idViagem);
    void delete(Long idFuncionario, Long idCarro);
    List<Viagem> findViagemByDataEntregaWithMonthAndYear(Integer month, Integer year);

}
