package com.br.carmanager.api.controller;

import com.br.carmanager.api.controller.dto.LoginDto;
import com.br.carmanager.api.controller.dto.TokenDto;
import com.br.carmanager.api.core.security.TokenService;
import com.br.carmanager.api.domain.exception.LoginInvalidException;
import com.br.carmanager.api.openapi.controller.AutenticacaoControllerOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AutenticacaoController implements AutenticacaoControllerOpenApi {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginDto loginForm) {

		UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();

		try {
			Authentication authentication = authenticationManager.authenticate(dadosLogin);

			// devolver token /geracao token
			String token = tokenService.gerarToken(authentication);

			return ResponseEntity.ok(new TokenDto(token, "Bearer"));

		} catch (AuthenticationException e) {
			throw new LoginInvalidException(String.format("Login ou senha está inválido"));
		}

	}

}