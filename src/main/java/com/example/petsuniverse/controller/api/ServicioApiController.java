package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Servicio;
import com.example.petsuniverse.service.ServicioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Servicio}: {@code /api/servicio}.
 */
@RestController
@RequestMapping("/api/servicio")
public class ServicioApiController extends CrudApiController<Servicio> {

    public ServicioApiController(ServicioService service) {
        super(service);
    }
}
