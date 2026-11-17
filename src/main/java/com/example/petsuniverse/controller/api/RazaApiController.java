package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Raza;
import com.example.petsuniverse.service.RazaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Raza}: {@code /api/raza}.
 */
@RestController
@RequestMapping("/api/raza")
public class RazaApiController extends CrudApiController<Raza> {

    public RazaApiController(RazaService service) {
        super(service);
    }
}
