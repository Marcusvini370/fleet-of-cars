package com.br.carmanager.api.core.security;

import com.br.carmanager.api.domain.model.Funcionario;
import com.br.carmanager.api.domain.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private FuncionarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Funcionario> usuario = usuarioRepository.findByLogin(username);
		if (usuario.isPresent()) {

			// se usuario estiver presente /recupera o usuario
			return usuario.get();

		}

		throw new UsernameNotFoundException("Usuario não encontrado");
	}

}