package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.TipoUsuario;
import com.example.petsuniverse.service.TipoUsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link TipoUsuario}: {@code /api/tipo_usuario}.
 */
@RestController
@RequestMapping("/api/tipo_usuario")
public class TipoUsuarioApiController extends CrudApiController<TipoUsuario> {

    public TipoUsuarioApiController(TipoUsuarioService service) {
        super(service);
    }
}
