package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Especie;
import com.example.petsuniverse.service.EspecieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Especie}: {@code /api/especie}.
 */
@RestController
@RequestMapping("/api/especie")
public class EspecieApiController extends CrudApiController<Especie> {

    public EspecieApiController(EspecieService service) {
        super(service);
    }
}
