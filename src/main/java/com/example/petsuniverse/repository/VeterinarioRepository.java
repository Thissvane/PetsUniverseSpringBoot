package com.example.petsuniverse.repository;

import com.example.petsuniverse.entity.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Acceso a datos de {@link Veterinario}.
 */
public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
}
