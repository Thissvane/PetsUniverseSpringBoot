package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link EstadoCita}.
 */
public interface EstadoCitaRepository extends JpaRepository<EstadoCita, Integer> {
}
