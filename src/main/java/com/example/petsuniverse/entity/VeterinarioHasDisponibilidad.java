package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla de unión {@code veterinario_has_disponibilidad}.
 * Las asociaciones son de solo lectura; los identificadores se envían en {@code id}.
 */
@Entity
@Table(name = "veterinario_has_disponibilidad")
@Getter
@Setter
public class VeterinarioHasDisponibilidad {

    @EmbeddedId
    @NotNull
    @Valid
    private VeterinarioHasDisponibilidadId id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinario_id_veterinario", insertable = false, updatable = false)
    private Veterinario veterinario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disponibilidad_id_dIsponibilidad", insertable = false, updatable = false)
    private Disponibilidad disponibilidad;
}
