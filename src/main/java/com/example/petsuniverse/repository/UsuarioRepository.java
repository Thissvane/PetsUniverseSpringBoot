package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Usuario}.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
