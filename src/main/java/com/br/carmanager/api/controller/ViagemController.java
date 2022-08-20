package com.br.carmanager.api.controller;

import com.br.carmanager.api.domain.model.Viagem;
import com.br.carmanager.api.domain.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/viagem", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Viagem>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(viagemService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Viagem> saveViagem(@RequestBody Viagem viagem) {
        return ResponseEntity.ok(viagemService.save(viagem));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        viagemService.delete(id);
    }


}
