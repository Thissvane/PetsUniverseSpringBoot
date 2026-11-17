package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Cita}.
 */
public interface CitaRepository extends JpaRepository<Cita, Integer> {
}
