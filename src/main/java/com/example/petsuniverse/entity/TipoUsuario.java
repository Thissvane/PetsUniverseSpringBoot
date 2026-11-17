package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code tipo_usuario}.
 */
@Entity
@Table(name = "tipo_usuario")
@Getter
@Setter
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_usuario")
    private Integer idTipoUsuario;

    @NotBlank(message = "Nombre del tipo: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "nombre_tipo", nullable = false, length = 45)
    private String nombreTipo;

}
