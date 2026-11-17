package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Permisos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Permisos}.
 */
public interface PermisosRepository extends JpaRepository<Permisos, Integer> {
}
