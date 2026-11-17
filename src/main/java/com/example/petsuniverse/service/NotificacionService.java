package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Notificacion;
import com.example.petsuniverse.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Notificacion}.
 */
@Service
public class NotificacionService extends CrudService<Notificacion, Integer> {

    public NotificacionService(NotificacionRepository repository) {
        super(repository);
    }
}
