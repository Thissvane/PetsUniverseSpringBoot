package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code especie}.
 */
@Entity
@Table(name = "especie")
@Getter
@Setter
public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especie")
    private Integer idEspecie;

    @NotBlank(message = "Nombre de la especie: campo obligatorio.")
    @Size(max = 60, message = "Máximo 60 caracteres.")
    @Column(name = "nombre_especie", nullable = false, length = 60)
    private String nombreEspecie;

    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "Descripcion", length = 45)
    private String descripcion;

}
