package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.TipoNotificacion;
import com.example.petsuniverse.service.TipoNotificacionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link TipoNotificacion}: {@code /api/tipo_notificacion}.
 */
@RestController
@RequestMapping("/api/tipo_notificacion")
public class TipoNotificacionApiController extends CrudApiController<TipoNotificacion> {

    public TipoNotificacionApiController(TipoNotificacionService service) {
        super(service);
    }
}
