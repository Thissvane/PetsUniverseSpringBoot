package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.VeterinarioHasDisponibilidad;
import com.example.petsuniverse.entity.VeterinarioHasDisponibilidadId;
import com.example.petsuniverse.service.VeterinarioHasDisponibilidadService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API REST de la tabla de unión {@code veterinario_has_disponibilidad}: {@code /api/veterinario_has_disponibilidad}.
 */
@RestController
@RequestMapping("/api/veterinario_has_disponibilidad")
public class VeterinarioHasDisponibilidadApiController {

    private final VeterinarioHasDisponibilidadService service;

    public VeterinarioHasDisponibilidadApiController(VeterinarioHasDisponibilidadService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<VeterinarioHasDisponibilidad> listar() {
        return service.listar();
    }

    @PostMapping("/guardar")
    public ResponseEntity<VeterinarioHasDisponibilidad> guardar(@Valid @RequestBody VeterinarioHasDisponibilidad entidad) {
        return ResponseEntity.ok(service.guardar(entidad));
    }

    @DeleteMapping("/eliminar/{veterinarioId}/{disponibilidadId}")
    public ResponseEntity<Void> eliminar(@PathVariable("veterinarioId") Integer veterinarioId,
                                         @PathVariable("disponibilidadId") Integer disponibilidadId) {
        service.eliminar(new VeterinarioHasDisponibilidadId(veterinarioId, disponibilidadId));
        return ResponseEntity.noContent().build();
    }
}
