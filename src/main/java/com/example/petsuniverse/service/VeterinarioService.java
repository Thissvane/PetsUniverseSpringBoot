package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Veterinario;
import com.example.petsuniverse.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Veterinario}.
 */
@Service
public class VeterinarioService extends CrudService<Veterinario, Integer> {

    public VeterinarioService(VeterinarioRepository repository) {
        super(repository);
    }
}
