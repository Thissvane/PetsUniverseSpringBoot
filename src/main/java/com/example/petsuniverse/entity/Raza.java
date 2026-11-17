package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code raza}.
 */
@Entity
@Table(name = "raza")
@Getter
@Setter
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_raza")
    private Integer idRaza;

    @NotBlank(message = "Nombre de la raza: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "nombre_raza", nullable = false, length = 45)
    private String nombreRaza;

    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "descripcion", length = 45)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "especie_id_especie", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private Especie especie;

}
