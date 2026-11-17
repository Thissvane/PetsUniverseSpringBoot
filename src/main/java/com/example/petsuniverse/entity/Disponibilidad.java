package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entidad que mapea la tabla {@code disponibilidad}.
 */
@Entity
@Table(name = "disponibilidad")
@Getter
@Setter
public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dIsponibilidad")
    private Integer idDisponibilidad;

    @NotNull(message = "Día de la semana (1-7): campo obligatorio.")
    @Min(value = 1, message = "El día debe estar entre 1 y 7.")
    @Max(value = 7, message = "El día debe estar entre 1 y 7.")
    @Column(name = "dia_semana", nullable = false)
    private Integer diaSemana;

    @NotNull(message = "Hora de inicio: campo obligatorio.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @NotNull(message = "Hora de fin: campo obligatorio.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

}
