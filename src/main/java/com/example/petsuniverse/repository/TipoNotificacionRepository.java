package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.TipoNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link TipoNotificacion}.
 */
public interface TipoNotificacionRepository extends JpaRepository<TipoNotificacion, Integer> {
}
