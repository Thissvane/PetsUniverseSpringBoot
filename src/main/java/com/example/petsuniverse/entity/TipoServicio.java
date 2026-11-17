package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code tipo_servicio}.
 */
@Entity
@Table(name = "tipo_servicio")
@Getter
@Setter
public class TipoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_servicio")
    private Integer idTipoServicio;

    @NotBlank(message = "Código: campo obligatorio.")
    @Size(max = 20, message = "Máximo 20 caracteres.")
    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @NotBlank(message = "Descripción: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;

}
