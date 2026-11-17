package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.TipoServicio;
import com.example.petsuniverse.service.TipoServicioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link TipoServicio}: {@code /api/tipo_servicio}.
 */
@RestController
@RequestMapping("/api/tipo_servicio")
public class TipoServicioApiController extends CrudApiController<TipoServicio> {

    public TipoServicioApiController(TipoServicioService service) {
        super(service);
    }
}
