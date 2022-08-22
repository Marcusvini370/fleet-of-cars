package com.br.carmanager.api.controller;

import com.br.carmanager.api.domain.dto.FuncionarioDTO;
import com.br.carmanager.api.domain.dto.input.FuncionarioInput;
import com.br.carmanager.api.domain.service.FuncionarioService;
import com.br.carmanager.api.openapi.controller.FuncionarioControllerOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/funcionarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class FuncionarioController implements FuncionarioControllerOpenApi {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> findAll() {
        return ResponseEntity.ok(funcionarioService.findAll());
    }

    @GetMapping("/page")
    public ResponseEntity<Page<FuncionarioDTO>> listarFuncionariosPage(
            @PageableDefault(size = 5, sort = "nome") Pageable pageable) {
        return ResponseEntity.ok(funcionarioService.findAllPage(pageable));
    }

    @GetMapping("/{idFuncionario}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long idFuncionario) {
        return ResponseEntity.ok(funcionarioService.findById(idFuncionario));
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> saveFuncionario(@RequestBody @Valid FuncionarioInput funcionarioInput) {
        return ResponseEntity.ok(funcionarioService.save(funcionarioInput));
    }

    @PutMapping("/{idFuncionario}")
    public ResponseEntity<FuncionarioDTO> updateFuncionario(@PathVariable Long idFuncionario,
                                                @RequestBody @Valid FuncionarioInput funcionarioInput) {
        return ResponseEntity.ok(funcionarioService.update(idFuncionario, funcionarioInput));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        funcionarioService.delete(id);
    }

}
