package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Mascota;
import com.example.petsuniverse.service.MascotaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Mascota}: {@code /api/mascota}.
 */
@RestController
@RequestMapping("/api/mascota")
public class MascotaApiController extends CrudApiController<Mascota> {

    public MascotaApiController(MascotaService service) {
        super(service);
    }
}
