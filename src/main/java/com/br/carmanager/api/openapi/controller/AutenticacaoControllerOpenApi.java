package com.br.carmanager.api.openapi.controller;

import com.br.carmanager.api.controller.dto.LoginDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;


@Api(tags = "Autenticação")
public interface AutenticacaoControllerOpenApi {

    @ApiOperation("Autentica o login de um funcionário")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500 ,message = "Erro interno do Servidor"),
            @ApiResponse(code = 400, message = "Login ou senha está incorreto.")})
    ResponseEntity<?> autenticar(LoginDto loginForm);
}
