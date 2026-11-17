package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.Usuario;
import com.example.petsuniverse.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link Usuario}: {@code /api/usuario}.
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioApiController extends CrudApiController<Usuario> {

    public UsuarioApiController(UsuarioService service) {
        super(service);
    }
}
