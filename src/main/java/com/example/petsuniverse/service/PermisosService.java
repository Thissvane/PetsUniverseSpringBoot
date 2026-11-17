package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Permisos;
import com.example.petsuniverse.repository.PermisosRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Permisos}.
 */
@Service
public class PermisosService extends CrudService<Permisos, Integer> {

    public PermisosService(PermisosRepository repository) {
        super(repository);
    }
}
