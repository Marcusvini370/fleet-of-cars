package com.br.carmanager.api.controller;

import com.br.carmanager.api.domain.model.Funcionario;
import com.br.carmanager.api.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/funcionarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        return ResponseEntity.ok(funcionarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Funcionario> saveFuncionario(@RequestBody @Valid Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.save(funcionario));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        funcionarioService.delete(id);
    }

}
