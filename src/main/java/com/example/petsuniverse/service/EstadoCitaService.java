package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.EstadoCita;
import com.example.petsuniverse.repository.EstadoCitaRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link EstadoCita}.
 */
@Service
public class EstadoCitaService extends CrudService<EstadoCita, Integer> {

    public EstadoCitaService(EstadoCitaRepository repository) {
        super(repository);
    }
}
