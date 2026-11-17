package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.EstadoCita;
import com.example.petsuniverse.service.EstadoCitaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link EstadoCita}: {@code /api/estado_cita}.
 */
@RestController
@RequestMapping("/api/estado_cita")
public class EstadoCitaApiController extends CrudApiController<EstadoCita> {

    public EstadoCitaApiController(EstadoCitaService service) {
        super(service);
    }
}
