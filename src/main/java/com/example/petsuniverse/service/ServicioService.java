package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Servicio;
import com.example.petsuniverse.repository.ServicioRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Servicio}.
 */
@Service
public class ServicioService extends CrudService<Servicio, Integer> {

    public ServicioService(ServicioRepository repository) {
        super(repository);
    }
}
