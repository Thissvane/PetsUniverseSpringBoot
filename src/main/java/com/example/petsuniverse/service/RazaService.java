package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Raza;
import com.example.petsuniverse.repository.RazaRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Raza}.
 */
@Service
public class RazaService extends CrudService<Raza, Integer> {

    public RazaService(RazaRepository repository) {
        super(repository);
    }
}
