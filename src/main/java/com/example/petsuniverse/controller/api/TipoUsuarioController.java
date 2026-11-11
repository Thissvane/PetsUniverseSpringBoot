package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.TipoUsuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.petsuniverse.service.TipoUsuarioService;
import java.util.List;

@RestController//si tiene la anotacion res
@RequestMapping("/api/tipo_usuario")
public class TipoUsuarioController {
    private final TipoUsuarioService service;

    public TipoUsuarioController(TipoUsuarioService service){
        this.service = service;
    }

    @GetMapping("/listar")
    public List<TipoUsuario> findAll(){
        return  service.listar();
    }

    @PostMapping("/guardar")
    public TipoUsuario guardar(TipoUsuario usuario){
        return service.guardar(usuario);
    }
}
