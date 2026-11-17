package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.TipoUsuario;
import com.example.petsuniverse.repository.TipoUsuarioRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link TipoUsuario}.
 */
@Service
public class TipoUsuarioService extends CrudService<TipoUsuario, Integer> {

    public TipoUsuarioService(TipoUsuarioRepository repository) {
        super(repository);
    }
}
