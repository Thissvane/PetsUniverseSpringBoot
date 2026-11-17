package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Cita;
import com.example.petsuniverse.service.CitaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Cita}: {@code /api/cita}.
 */
@RestController
@RequestMapping("/api/cita")
public class CitaApiController extends CrudApiController<Cita> {

    public CitaApiController(CitaService service) {
        super(service);
    }
}
