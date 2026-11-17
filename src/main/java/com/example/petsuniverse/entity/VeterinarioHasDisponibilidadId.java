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
 * Clave compuesta de la tabla {@code veterinario_has_disponibilidad}.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VeterinarioHasDisponibilidadId implements Serializable {

    @NotNull
    @Column(name = "veterinario_id_veterinario")
    private Integer veterinarioId;

    @NotNull
    @Column(name = "disponibilidad_id_dIsponibilidad")
    private Integer disponibilidadId;
}
