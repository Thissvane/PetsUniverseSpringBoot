package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.Especie;
import com.example.petsuniverse.repository.EspecieRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link Especie}.
 */
@Service
public class EspecieService extends CrudService<Especie, Integer> {

    public EspecieService(EspecieRepository repository) {
        super(repository);
    }
}
