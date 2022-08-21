package com.br.carmanager.api.controller;

import com.br.carmanager.api.domain.dto.ViagemDTO;
import com.br.carmanager.api.domain.dto.input.ViagemInput;
import com.br.carmanager.api.domain.model.Viagem;
import com.br.carmanager.api.domain.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/viagem", produces = MediaType.APPLICATION_JSON_VALUE)
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @GetMapping("/{idViagem}")
    public ResponseEntity<ViagemDTO> findById(@PathVariable Long idViagem) {
        return ResponseEntity.ok(viagemService.findById(idViagem));
    }

    @PostMapping("/{idFuncionario}/{idCarro}")
    public ResponseEntity<ViagemDTO> saveViagem(@PathVariable Long idFuncionario, @PathVariable Long idCarro, ViagemInput viagemInput) {
        return ResponseEntity.ok(viagemService.save(viagemInput, idFuncionario, idCarro));
    }

    @DeleteMapping("/{idFuncionario}/{idCarro}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idFuncionario, @PathVariable Long idCarro) {
        viagemService.delete(idFuncionario, idCarro);
    }

    @GetMapping("/{month}/{year}")
    public ResponseEntity<List<Viagem>> findViagemByDataEntregaWithMonthAndYear(@PathVariable Integer month, @PathVariable Integer year) {
        return ResponseEntity.ok(viagemService.findViagemByDataEntregaWithMonthAndYear(month, year));
    }
}
