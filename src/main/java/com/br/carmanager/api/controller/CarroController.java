package com.br.carmanager.api.controller;

import com.br.carmanager.api.domain.dto.CarroDTO;
import com.br.carmanager.api.domain.dto.input.CarroInput;
import com.br.carmanager.api.domain.service.CarroService;
import com.br.carmanager.api.openapi.controller.CarroControllerOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/carros", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarroController implements CarroControllerOpenApi {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll() {
        return ResponseEntity.ok(carroService.findAll());
    }

    @GetMapping("/retirados")
    public ResponseEntity<List<CarroDTO>> findCarByStatusUnavailable() {
        return ResponseEntity.ok(carroService.findCarByStatusUnavailable());
    }

    @GetMapping("/{idCarro}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Long idCarro) {
        return ResponseEntity.ok(carroService.findById(idCarro));
    }

    @PostMapping
    public ResponseEntity<CarroDTO> saveCarro(@RequestBody @Valid CarroInput carroInput) {
        return ResponseEntity.ok(carroService.save(carroInput));
    }

    @PutMapping("/{idCarro}")
    public ResponseEntity<CarroDTO> updateCarro(@PathVariable Long idCarro,
                                                      @RequestBody @Valid CarroInput carroInput) {
        return ResponseEntity.ok(carroService.update(idCarro, carroInput));
    }

    @DeleteMapping("/{idCarro}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long idCarro) {
        carroService. delete(idCarro);
    }


}
