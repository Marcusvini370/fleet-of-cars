package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.assembler.ViagemDtoAssembler;
import com.br.carmanager.api.assembler.ViagemInputDisassembler;
import com.br.carmanager.api.domain.dto.ViagemDTO;
import com.br.carmanager.api.domain.dto.input.ViagemInput;
import com.br.carmanager.api.domain.enums.StatusCarro;
import com.br.carmanager.api.domain.exception.FuncionarioWithCarInUseException;
import com.br.carmanager.api.domain.exception.NegocioException;
import com.br.carmanager.api.domain.exception.ViagemNotFoundException;
import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.model.Funcionario;
import com.br.carmanager.api.domain.model.Viagem;
import com.br.carmanager.api.domain.repository.ViagemRepository;
import com.br.carmanager.api.domain.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class ViagemServiceImpl implements ViagemService {

    private static final String MSG_VIAGEM_NAO_ENCONTRADA = "Não existe um cadastro de viagem com o código %d";
    private static final String MSG_FUNCIONARIO_COM_CARRO = "Funcionário com o código %d, já está utilizando um carro com o código %d";
    @Autowired
    private ViagemRepository viagemRepository;

    @Autowired
    private CarroServiceImpl carroService;

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @Autowired
    private ViagemDtoAssembler viagemDtoAssembler;

    @Autowired
    ViagemInputDisassembler viagemInputDisassembler;

    @Override
    public ViagemDTO save(ViagemInput viagemInput, Long idFuncionario, Long idCarro) {

        Funcionario funcionario = funcionarioService.BuscarOuFalhar(idFuncionario);
        Carro carro = carroService.BuscarOuFalhar(idCarro);

        Viagem viagem = viagemInputDisassembler.toDomainObject(viagemInput);

        Viagem validateFuncionario = viagemRepository.findViagemByFuncionarioWithCarInUse(funcionario.getId(), carro.getId());

        if (carro.getStatus().equals(StatusCarro.DISPONIVEL) && validateFuncionario == null) {
            viagem.setFuncionario(funcionario);
            viagem.setCarro(carro);

            viagem.getCarro().setStatus(StatusCarro.INDISPONIVEL);
            return viagemDtoAssembler.toModel(viagemRepository.save(viagem));
        }

            throw new FuncionarioWithCarInUseException(String.format(MSG_FUNCIONARIO_COM_CARRO, funcionario.getId(), carro.getId()));
    }

    @Override
    public ViagemDTO findById(Long id) {
        return viagemDtoAssembler.toModel(BuscarOuFalhar(id));
    }

    @Override
    public void delete(Long idFuncionario,Long idCarro) {
        //Viagem viagem = BuscarOuFalhar(idViagem);
        Funcionario funcionario = funcionarioService.BuscarOuFalhar(idFuncionario);
        Carro carro = carroService.BuscarOuFalhar(idCarro);

        Viagem viagem = viagemRepository.findViagemByFuncionarioWithCarInUse(funcionario.getId(), carro.getId());

        List<Viagem> viagemV = viagemRepository.findViagemByFuncionarioIdAndCarroId(funcionario.getId(), carro.getId());

        if (viagemV.size() > 0) {
            if (viagem != null && viagem.getDataEntrega() == null) {
                viagem.setDataEntrega(OffsetDateTime.now());
                viagem.getCarro().setStatus(StatusCarro.DISPONIVEL);

                viagemRepository.save(viagem);
            } else {
                throw new NegocioException(String.format("A viagem já se encontra concluída!"));
            }
        } else {
            throw new FuncionarioWithCarInUseException(String.format("Não existe viagem registrada com o funcionario %s usando o carro codigo %d", funcionario.getNome(), carro.getId()));
        }
    }

    @Override
    public List<Viagem> findViagemByDataEntregaWithMonthAndYear(Integer month, Integer year) {
        return viagemRepository.findViagemByDataEntregaWithMonthAndYear(month, year);
    }

    public Viagem BuscarOuFalhar(Long id) {
        return viagemRepository.findById(id)
                .orElseThrow(() -> new ViagemNotFoundException(String.format(MSG_VIAGEM_NAO_ENCONTRADA, id)));
    }
}
