package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.TipoServicio;
import com.example.petsuniverse.repository.TipoServicioRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link TipoServicio}.
 */
@Service
public class TipoServicioService extends CrudService<TipoServicio, Integer> {

    public TipoServicioService(TipoServicioRepository repository) {
        super(repository);
    }
}
