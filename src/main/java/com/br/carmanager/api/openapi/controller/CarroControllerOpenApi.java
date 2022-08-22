package com.br.carmanager.api.openapi.controller;

import com.br.carmanager.api.domain.dto.CarroDTO;
import com.br.carmanager.api.domain.dto.input.CarroInput;
import com.br.carmanager.api.exceptionhandler.Problem;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "Carros")
public interface CarroControllerOpenApi {

    @ApiOperation("Lista todos os Carros")
    ResponseEntity<List<CarroDTO>> findAll();

    @ApiOperation("Lista os carros que estão em uso")
     ResponseEntity<List<CarroDTO>> findCarByStatusUnavailable();

    @ApiOperation("Busca Carro por id")
    @ApiResponses({ @ApiResponse(code = 404, message = "Id do carro é inválido", response = Problem.class),
            @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
    public ResponseEntity<CarroDTO> findById(@ApiParam(value = "Id de um Carro", example = "1", required = true) Long idCarro);

    @ApiOperation("Cadastra um Carro")
    @ApiResponses({ @ApiResponse(code = 201, message = "Carro cadastrado"),
            @ApiResponse(code = 400, message = "Dados do carro estão inválidos", response = Problem.class),
            @ApiResponse(code = 406, message = "Recurso não possui representação que pode ser aceita pelo consumidor",
                    response = Problem.class),@ApiResponse(code = 500 ,message = "Erro interno do Servidor"),
            @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
    public ResponseEntity<CarroDTO> saveCarro(@ApiParam(name = "corpo", value = "Representação de um novo Carro") CarroInput carroInput);

    @ApiOperation("Atualiza um Carro por id")
    @ApiResponses({ @ApiResponse(code = 200, message = "Carro atualizado"),
            @ApiResponse(code = 404, message = "Carro não encontrado", response = Problem.class),
            @ApiResponse(code = 406, message = "Recurso não possui representação que pode ser aceita pelo consumidor",
                    response = Problem.class),@ApiResponse(code = 500 ,message = "Erro interno do Servidor"),
            @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
    public ResponseEntity<CarroDTO> updateCarro(@ApiParam(value = "Id de um Carro", example = "2", required = true) Long idCarro,
                                                @ApiParam(name = "corpo", value = "Representação de um Carro com os novos dados") CarroInput carroInput);

    @ApiOperation("Deleta uma carro por id")
    @ApiResponses({ @ApiResponse(code = 204, message = "Carro excluído"),
            @ApiResponse(code = 404, message = "Id do carro não encontrado", response = Problem.class),
            @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
     void deleteById(@ApiParam(value = "Id de um Carro", example = "2", required = true) Long idCarro);


}
