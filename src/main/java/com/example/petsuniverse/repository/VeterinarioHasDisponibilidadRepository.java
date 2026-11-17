package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.VeterinarioHasDisponibilidad;
import com.example.petsuniverse.entity.VeterinarioHasDisponibilidadId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link VeterinarioHasDisponibilidad}.
 */
public interface VeterinarioHasDisponibilidadRepository extends JpaRepository<VeterinarioHasDisponibilidad, VeterinarioHasDisponibilidadId> {
}
