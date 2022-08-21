package com.br.carmanager.api.controller;

import com.br.carmanager.api.domain.model.Viagem;
import com.br.carmanager.api.domain.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/viagem", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @GetMapping("/{idViagem}")
    public ResponseEntity<Viagem> findById(@PathVariable Long idViagem) {
        return ResponseEntity.ok(viagemService.findById(idViagem));
    }

    @PostMapping("/{idFuncionario}/{idCarro}")
    public ResponseEntity<Viagem> saveViagem(@PathVariable Long idFuncionario, @PathVariable Long idCarro, Viagem viagem) {
        return ResponseEntity.ok(viagemService.save(viagem, idFuncionario, idCarro));
    }

    @DeleteMapping("/{idViagem}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idViagem) {
        viagemService.delete(idViagem);
    }


}
