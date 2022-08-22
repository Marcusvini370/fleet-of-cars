package com.br.carmanager.api.openapi.controller;

import com.br.carmanager.api.domain.dto.FuncionarioDTO;
import com.br.carmanager.api.domain.dto.input.FuncionarioInput;
import com.br.carmanager.api.exceptionhandler.Problem;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = "Funcionarios")
public interface FuncionarioControllerOpenApi {

     @ApiOperation("Lista todos Funcionários")
     ResponseEntity<List<FuncionarioDTO>> findAll();

     @ApiOperation("Busca Funcionário por id")
     @ApiResponses({ @ApiResponse(code = 404, message = "Id do funcionário é inválido", response = Problem.class),
             @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
     ResponseEntity<FuncionarioDTO> findById(@ApiParam(value = "Id de um Funcionário", example = "1", required = true) Long idFuncionario);

     @ApiOperation("Cadastra um Funcionário")
     @ApiResponses({ @ApiResponse(code = 201, message = "Funcionário cadastrado"),
             @ApiResponse(code = 400, message = "Dados do funcionário estão inválidos", response = Problem.class),
             @ApiResponse(code = 406, message = "Recurso não possui representação que pode ser aceita pelo consumidor",
                     response = Problem.class),@ApiResponse(code = 500 ,message = "Erro interno do Servidor"),
             @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
     ResponseEntity<FuncionarioDTO> saveFuncionario(@ApiParam(name = "corpo", value = "Representação de um novo Funcionário") FuncionarioInput funcionarioInput);

     @ApiOperation("Atualiza um Funcionário por id")
     @ApiResponses({ @ApiResponse(code = 200, message = "Funcionário atualizado"),
             @ApiResponse(code = 404, message = "Funcionário não encontrado", response = Problem.class),
             @ApiResponse(code = 406, message = "Recurso não possui representação que pode ser aceita pelo consumidor",
                     response = Problem.class),@ApiResponse(code = 500 ,message = "Erro interno do Servidor"),
             @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
     ResponseEntity<FuncionarioDTO> updateFuncionario(@ApiParam(value = "Id de um Funcionário", example = "2", required = true) Long idFuncionario,
                                                      @ApiParam(name = "corpo", value = "Representação de um Funcionário com os novos dados")  FuncionarioInput funcionarioInput);

     @ApiOperation("Deleta uma Funcionário por id")
     @ApiResponses({ @ApiResponse(code = 204, message = "Funcionário excluído"),
             @ApiResponse(code = 404, message = "Id do funcionário não encontrado", response = Problem.class),
             @ApiResponse(code = 403, message = "Usuário não autorizado, faça sua autenticação")})
     void deleteById(@ApiParam(value = "Id de um Funcionário", example = "2", required = true) Long id);

}
