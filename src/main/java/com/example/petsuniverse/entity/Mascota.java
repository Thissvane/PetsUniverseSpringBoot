package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code Mascota}.
 */
@Entity
@Table(name = "Mascota")
@Getter
@Setter
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Mascota")
    private Integer idMascota;

    @NotBlank(message = "Nombre: campo obligatorio.")
    @Size(max = 20, message = "Máximo 20 caracteres.")
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @NotNull(message = "Peso (kg): campo obligatorio.")
    @Positive(message = "El peso debe ser mayor que cero.")
    @Digits(integer = 3, fraction = 2, message = "Máximo 3 enteros y 2 decimales.")
    @Column(name = "peso", nullable = false, precision = 5, scale = 2)
    private BigDecimal peso;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id_usuario", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "raza_id_raza", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private Raza raza;

}
