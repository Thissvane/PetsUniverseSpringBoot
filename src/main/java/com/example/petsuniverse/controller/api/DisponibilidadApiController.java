package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Disponibilidad;
import com.example.petsuniverse.service.DisponibilidadService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Disponibilidad}: {@code /api/disponibilidad}.
 */
@RestController
@RequestMapping("/api/disponibilidad")
public class DisponibilidadApiController extends CrudApiController<Disponibilidad> {

    public DisponibilidadApiController(DisponibilidadService service) {
        super(service);
    }
}
