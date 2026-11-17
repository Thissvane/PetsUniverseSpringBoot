package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Especie}.
 */
public interface EspecieRepository extends JpaRepository<Especie, Integer> {
}
