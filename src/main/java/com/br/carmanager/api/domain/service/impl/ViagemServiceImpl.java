package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.domain.enums.StatusCarro;
import com.br.carmanager.api.domain.exception.ViagemNotFoundException;
import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.model.Funcionario;
import com.br.carmanager.api.domain.model.Viagem;
import com.br.carmanager.api.domain.repository.ViagemRepository;
import com.br.carmanager.api.domain.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

@Service
public class ViagemServiceImpl implements ViagemService {

    private static final String MSG_VIAGEM_NAO_ENCONTRADA = "Não existe um cadastro de viagem com o código %d";


    @Autowired
    private ViagemRepository viagemRepository;

    @Autowired
    private CarroServiceImpl carroService;

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @Override
    public Viagem save(Viagem viagem, Long idFuncionario, Long idCarro) {

        Funcionario funcionario = funcionarioService.BuscarOuFalhar(idFuncionario);
        Carro carro = carroService.BuscarOuFalhar(idCarro);

        viagem.setFuncionario(funcionario);
        viagem.setCarro(carro);

        carro.setStatus(StatusCarro.INDISPONIVEL);
        carroService.save(carro);

        return viagemRepository.save(viagem);
    }

    @Override
    public Viagem findById(Long id) {
        return BuscarOuFalhar(id);
    }

    @Override
    public void delete(Long idViagem) {
        Viagem viagem = BuscarOuFalhar(idViagem);
        Carro carro = viagem.getCarro();

        viagem.setDataEntrega(OffsetDateTime.now());
        carro.setStatus(StatusCarro.DISPONIVEL);

        viagemRepository.save(viagem);
        carroService.save(carro);

    }

    public Viagem BuscarOuFalhar(Long id) {
        return viagemRepository.findById(id)
                .orElseThrow(() -> new ViagemNotFoundException(String.format(MSG_VIAGEM_NAO_ENCONTRADA, id)));
    }
}
