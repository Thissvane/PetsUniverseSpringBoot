package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code tipo_notificacion}.
 */
@Entity
@Table(name = "tipo_notificacion")
@Getter
@Setter
public class TipoNotificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_notificacion")
    private Integer idTipoNotificacion;

    @NotBlank(message = "Código: campo obligatorio.")
    @Size(max = 20, message = "Máximo 20 caracteres.")
    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @NotBlank(message = "Nombre del tipo: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "nombre_tipo", nullable = false, length = 45)
    private String nombreTipo;

    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "descripcion", length = 45)
    private String descripcion;

}
