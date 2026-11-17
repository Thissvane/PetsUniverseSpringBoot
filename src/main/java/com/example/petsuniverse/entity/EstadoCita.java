package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code estado_cita}.
 */
@Entity
@Table(name = "estado_cita")
@Getter
@Setter
public class EstadoCita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_cita")
    private Integer idEstadoCita;

    @NotBlank(message = "Nombre del estado: campo obligatorio.")
    @Size(max = 40, message = "Máximo 40 caracteres.")
    @Column(name = "nombre_estado", nullable = false, length = 40)
    private String nombreEstado;

}
