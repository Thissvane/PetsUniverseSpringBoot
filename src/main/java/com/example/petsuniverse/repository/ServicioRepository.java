package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Servicio}.
 */
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
}
