package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Disponibilidad}.
 */
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Integer> {
}
