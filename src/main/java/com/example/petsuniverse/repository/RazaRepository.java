package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Raza;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Raza}.
 */
public interface RazaRepository extends JpaRepository<Raza, Integer> {
}
