package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code veterinario}.
 */
@Entity
@Table(name = "veterinario")
@Getter
@Setter
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinario")
    private Integer idVeterinario;

    @NotBlank(message = "Número de licencia: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "num_licencia", nullable = false, length = 45)
    private String numLicencia;

    @NotBlank(message = "Firma digital (archivo): campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "firma_digital", nullable = false, length = 45)
    private String firmaDigital;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id_usuario", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private Usuario usuario;

}
