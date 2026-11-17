package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.service.CrudService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST base para entidades con clave entera.
 * Rutas: {@code GET /listar}, {@code GET /{id}}, {@code POST /guardar} (crea o actualiza según el id)
 * y {@code DELETE /eliminar/{id}}.
 *
 * @param <T> tipo de entidad
 */
public abstract class CrudApiController<T> {

    protected final CrudService<T, Integer> service;

    protected CrudApiController(CrudService<T, Integer> service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public List<T> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> buscar(@PathVariable("id") Integer id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/guardar")
    public ResponseEntity<T> guardar(@Valid @RequestBody T entidad) {
        return ResponseEntity.ok(service.guardar(entidad));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
