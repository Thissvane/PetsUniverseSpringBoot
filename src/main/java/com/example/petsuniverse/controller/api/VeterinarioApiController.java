package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Veterinario;
import com.example.petsuniverse.service.VeterinarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Veterinario}: {@code /api/veterinario}.
 */
@RestController
@RequestMapping("/api/veterinario")
public class VeterinarioApiController extends CrudApiController<Veterinario> {

    public VeterinarioApiController(VeterinarioService service) {
        super(service);
    }
}
