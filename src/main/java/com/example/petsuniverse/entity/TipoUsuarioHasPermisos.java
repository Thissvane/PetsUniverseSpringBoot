package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla de unión {@code tipo_usuario_has_permisos}.
 * Las asociaciones son de solo lectura; los identificadores se envían en {@code id}.
 */
@Entity
@Table(name = "tipo_usuario_has_permisos")
@Getter
@Setter
public class TipoUsuarioHasPermisos {

    @EmbeddedId
    @NotNull
    @Valid
    private TipoUsuarioHasPermisosId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_usuario_id_tipo_usuario", insertable = false, updatable = false)
    private TipoUsuario tipoUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permisos_id_permisos", insertable = false, updatable = false)
    private Permisos permisos;
}
