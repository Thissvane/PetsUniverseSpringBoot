package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code permisos}.
 */
@Entity
@Table(name = "permisos")
@Getter
@Setter
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permisos")
    private Integer idPermisos;

    @NotBlank(message = "Nombre del permiso: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "nombre_permisos", nullable = false, length = 45)
    private String nombrePermisos;

    @NotBlank(message = "Descripción: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;

}
