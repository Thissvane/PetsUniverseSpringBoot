package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Cita;
import com.example.petsuniverse.repository.CitaRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Cita}.
 */
@Service
public class CitaService extends CrudService<Cita, Integer> {

    public CitaService(CitaRepository repository) {
        super(repository);
    }
}
