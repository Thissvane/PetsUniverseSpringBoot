package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Permisos;
import com.example.petsuniverse.service.PermisosService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Permisos}: {@code /api/permisos}.
 */
@RestController
@RequestMapping("/api/permisos")
public class PermisosApiController extends CrudApiController<Permisos> {

    public PermisosApiController(PermisosService service) {
        super(service);
    }
}
