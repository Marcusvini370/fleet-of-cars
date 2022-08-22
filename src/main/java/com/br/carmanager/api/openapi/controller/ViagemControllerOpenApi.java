package com.br.carmanager.api.openapi.controller;

import com.br.carmanager.api.domain.dto.ViagemDTO;
import com.br.carmanager.api.domain.dto.input.ViagemInput;
import com.br.carmanager.api.domain.model.Viagem;
import com.br.carmanager.api.exceptionhandler.Problem;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "Viagens")
public interface ViagemControllerOpenApi {

    @ApiOperation("Busca Viagem por id")
    @ApiResponses({ @ApiResponse(code = 404, message = "Id da Viagem é inválido", response = Problem.class),
            @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
    ResponseEntity<ViagemDTO> findById(@ApiParam(value = "Id de uma viagem", example = "1", required = true) Long idViagem);

    @ApiOperation("Cadastra uma Viagem")
    @ApiResponses({ @ApiResponse(code = 201, message = "Viagem cadastrado"),
            @ApiResponse(code = 400, message = "Dados da viagem estão inválidos", response = Problem.class),
            @ApiResponse(code = 406, message = "Recurso não possui representação que pode ser aceita pelo consumidor",
                    response = Problem.class),@ApiResponse(code = 500 ,message = "Erro interno do Servidor"),
            @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
    ResponseEntity<ViagemDTO> saveViagem(
                   @ApiParam(value = "Id de uma funcionário", example = "1", required = true) Long idFuncionario,
                   @ApiParam(value = "Id de uma carro", example = "1", required = true) Long idCarro,
                   @ApiParam(name = "corpo", value = "Representação de uma nova Viagem") ViagemInput viagemInput);

    @ApiOperation("Realiza a devolução do carro e encerra a viagem")
    @ApiResponses({ @ApiResponse(code = 204, message = "Viagem concluída"),
            @ApiResponse(code = 404, message = "Id do funcionário ou carro não foi encontrado", response = Problem.class),
            @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
    void deleteByDevolucao( @ApiParam(value = "Id de uma funcionário", example = "1", required = true) Long idFuncionario,
                 @ApiParam(value = "Id de uma carro", example = "1", required = true) Long idCarro);

    @ApiOperation("Busca de Viagens concluídas por mês e ano")
    ResponseEntity<List<Viagem>> findViagemByDataEntregaWithMonthAndYear(Integer month, Integer year);
}
