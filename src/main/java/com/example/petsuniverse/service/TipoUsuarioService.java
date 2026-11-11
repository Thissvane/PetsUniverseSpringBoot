package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.TipoUsuario;
import com.example.petsuniverse.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository repository;

    public TipoUsuarioService(TipoUsuarioRepository repository) {
        this.repository = repository;
    }

    public List<TipoUsuario> listar(){
        return repository.findAll();
    }

    public TipoUsuario guardar(TipoUsuario usuario){
        return repository.save(usuario);
    }

    public TipoUsuario insertar(TipoUsuario usuario){
        return repository.save(usuario);
    }
}
