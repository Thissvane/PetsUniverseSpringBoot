package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.TipoUsuarioHasPermisos;
import com.example.petsuniverse.entity.TipoUsuarioHasPermisosId;
import com.example.petsuniverse.service.TipoUsuarioHasPermisosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API REST de la tabla de unión {@code tipo_usuario_has_permisos}: {@code /api/tipo_usuario_has_permisos}.
 */
@RestController
@RequestMapping("/api/tipo_usuario_has_permisos")
public class TipoUsuarioHasPermisosApiController {

    private final TipoUsuarioHasPermisosService service;

    public TipoUsuarioHasPermisosApiController(TipoUsuarioHasPermisosService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<TipoUsuarioHasPermisos> listar() {
        return service.listar();
    }

    @PostMapping("/guardar")
    public ResponseEntity<TipoUsuarioHasPermisos> guardar(@Valid @RequestBody TipoUsuarioHasPermisos entidad) {
        return ResponseEntity.ok(service.guardar(entidad));
    }

    @DeleteMapping("/eliminar/{tipoUsuarioId}/{permisosId}")
    public ResponseEntity<Void> eliminar(@PathVariable("tipoUsuarioId") Integer tipoUsuarioId,
                                         @PathVariable("permisosId") Integer permisosId) {
        service.eliminar(new TipoUsuarioHasPermisosId(tipoUsuarioId, permisosId));
        return ResponseEntity.noContent().build();
    }
}
