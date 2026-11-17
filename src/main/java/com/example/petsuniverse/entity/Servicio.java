package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code servicio}.
 */
@Entity
@Table(name = "servicio")
@Getter
@Setter
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @NotBlank(message = "Descripción: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "descripcion", nullable = false, length = 45)
    private String descripcion;

    @NotNull(message = "Precio (COP): campo obligatorio.")
    @PositiveOrZero(message = "El precio no puede ser negativo.")
    @Digits(integer = 8, fraction = 2, message = "Máximo 8 enteros y 2 decimales.")
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @NotNull(message = "Duración estimada (min): campo obligatorio.")
    @Positive(message = "La duración debe ser mayor que cero.")
    @Column(name = "duracion_estimada", nullable = false)
    private Integer duracionEstimada;

    @NotNull(message = "Activo: campo obligatorio.")
    @Column(name = "estado", nullable = false, columnDefinition = "TINYINT")
    private Boolean estado;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipo_servicio_id_tipo_servicio", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private TipoServicio tipoServicio;

}
