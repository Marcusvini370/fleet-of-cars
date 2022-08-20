package com.br.carmanager.api.controller;

import com.br.carmanager.api.domain.model.Carro;
import com.br.carmanager.api.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/carros ", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> findAll() {
        return ResponseEntity.ok(carroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Carro>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(carroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Carro> saveCarro(@RequestBody Carro carro) {
        return ResponseEntity.ok(carroService.save(carro));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        carroService.delete(id);
    }


}
