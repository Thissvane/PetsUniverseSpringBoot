package com.example.petsuniverse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Clave compuesta de la tabla {@code tipo_usuario_has_permisos}.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TipoUsuarioHasPermisosId implements Serializable {

    @NotNull
    @Column(name = "tipo_usuario_id_tipo_usuario")
    private Integer tipoUsuarioId;

    @NotNull
    @Column(name = "permisos_id_permisos")
    private Integer permisosId;
}
