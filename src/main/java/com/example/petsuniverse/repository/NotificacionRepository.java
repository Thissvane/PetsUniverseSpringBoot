package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Notificacion}.
 */
public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
}
