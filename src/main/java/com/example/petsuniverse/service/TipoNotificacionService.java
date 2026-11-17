package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.TipoNotificacion;
import com.example.petsuniverse.repository.TipoNotificacionRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link TipoNotificacion}.
 */
@Service
public class TipoNotificacionService extends CrudService<TipoNotificacion, Integer> {

    public TipoNotificacionService(TipoNotificacionRepository repository) {
        super(repository);
    }
}
