package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entidad que mapea la tabla {@code cita}.
 */
@Entity
@Table(name = "cita")
@Getter
@Setter
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer idCita;

    @NotNull(message = "Fecha: campo obligatorio.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @NotNull(message = "Hora: campo obligatorio.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @NotNull(message = "Pago autorizado: campo obligatorio.")
    @Column(name = "status_autorizacion", nullable = false, columnDefinition = "TINYINT")
    private Boolean statusAutorizacion;

    @NotNull(message = "Observaciones de tesorería: campo obligatorio.")
    @Size(max = 200, message = "Máximo 200 caracteres.")
    @Column(name = "observaciones_tesoreria", nullable = false, length = 200)
    private String observacionesTesoreria;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "Mascota_id_Mascota", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private Mascota mascota;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "servicio_id_servicio", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private Servicio servicio;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estado_cita_id_estado_cita", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private EstadoCita estadoCita;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "veterinario_id_veterinario", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private Veterinario veterinario;

}
