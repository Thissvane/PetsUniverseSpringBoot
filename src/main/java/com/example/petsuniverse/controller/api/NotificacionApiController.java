package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Notificacion;
import com.example.petsuniverse.service.NotificacionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Notificacion}: {@code /api/notificacion}.
 */
@RestController
@RequestMapping("/api/notificacion")
public class NotificacionApiController extends CrudApiController<Notificacion> {

    public NotificacionApiController(NotificacionService service) {
        super(service);
    }
}
