package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link TipoServicio}.
 */
public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer> {
}
