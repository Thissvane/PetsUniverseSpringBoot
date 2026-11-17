package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.TipoUsuarioHasPermisos;
import com.example.petsuniverse.entity.TipoUsuarioHasPermisosId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link TipoUsuarioHasPermisos}.
 */
public interface TipoUsuarioHasPermisosRepository extends JpaRepository<TipoUsuarioHasPermisos, TipoUsuarioHasPermisosId> {
}
