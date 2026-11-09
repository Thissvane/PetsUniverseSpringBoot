package com.example.petsuniverse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.petsuniverse.entity.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}