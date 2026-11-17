package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Mascota}.
 */
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
}
