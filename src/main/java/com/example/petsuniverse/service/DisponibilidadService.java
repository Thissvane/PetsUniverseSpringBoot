package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Disponibilidad;
import com.example.petsuniverse.repository.DisponibilidadRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Disponibilidad}.
 */
@Service
public class DisponibilidadService extends CrudService<Disponibilidad, Integer> {

    public DisponibilidadService(DisponibilidadRepository repository) {
        super(repository);
    }
}
