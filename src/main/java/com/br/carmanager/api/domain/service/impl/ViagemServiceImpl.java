package com.br.carmanager.api.domain.service.impl;

import com.br.carmanager.api.domain.model.Viagem;
import com.br.carmanager.api.domain.repository.ViagemRepository;
import com.br.carmanager.api.domain.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViagemServiceImpl implements ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    @Override
    public Viagem save(Viagem viagem) {
        return null;
    }

    @Override
    public Optional<Viagem> findById(Long id) {
        return viagemRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        viagemRepository.deleteById(id);
    }
}
