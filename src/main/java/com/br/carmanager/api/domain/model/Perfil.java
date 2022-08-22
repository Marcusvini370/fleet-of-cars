package com.br.carmanager.api.domain.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_perfil")
public class Perfil implements GrantedAuthority {
	

	private static final long serialVersionUID = 1L;
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	@Override
	public String getAuthority() {
		return nome;
	}

}