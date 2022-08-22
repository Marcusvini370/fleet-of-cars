package com.br.carmanager.api.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class LoginDto {
	
	@ApiModelProperty(example = "admin", required = true)
	private String login;

	@ApiModelProperty(example = "senij3@Masd4", required = true)
	private String password;

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(login, password);
	}

}