package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link TipoUsuario}.
 */
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
