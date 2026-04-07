package com.consultorio.controller;

import com.consultorio.model.CitaMedica;
import com.consultorio.service.CitaMedicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaMedicaController {

    private final CitaMedicaService citaMedicaService;

    public CitaMedicaController(CitaMedicaService citaMedicaService) {
        this.citaMedicaService = citaMedicaService;
    }

    @GetMapping
    public ResponseEntity<List<CitaMedica>> listarCitas() {
        return ResponseEntity.ok(citaMedicaService.listarCitas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaMedica> buscarPorId(@PathVariable Long id) {
        return citaMedicaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CitaMedica> registrarCita(@RequestBody CitaMedica citaMedica) {
        CitaMedica nuevaCita = citaMedicaService.registrarCita(citaMedica);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaMedica> actualizarCita(@PathVariable Long id, @RequestBody CitaMedica citaMedica) {
        return citaMedicaService.actualizarCita(id, citaMedica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable Long id) {
        if (citaMedicaService.eliminarCita(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}