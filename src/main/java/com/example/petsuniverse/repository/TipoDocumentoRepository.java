package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link TipoDocumento}.
 */
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Integer> {
}
