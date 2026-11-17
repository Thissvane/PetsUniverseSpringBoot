package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Mascota;
import com.example.petsuniverse.repository.MascotaRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Mascota}.
 */
@Service
public class MascotaService extends CrudService<Mascota, Integer> {

    public MascotaService(MascotaRepository repository) {
        super(repository);
    }
}
