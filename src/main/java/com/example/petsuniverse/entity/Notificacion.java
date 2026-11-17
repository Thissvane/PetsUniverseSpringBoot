package com.example.petsuniverse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad que mapea la tabla {@code notificacion}.
 */
@Entity
@Table(name = "notificacion")
@Getter
@Setter
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer idNotificacion;

    @NotBlank(message = "Asunto: campo obligatorio.")
    @Size(max = 200, message = "Máximo 200 caracteres.")
    @Column(name = "asunto", nullable = false, length = 200)
    private String asunto;

    @NotBlank(message = "Mensaje: campo obligatorio.")
    @Size(max = 255, message = "Máximo 255 caracteres.")
    @Column(name = "mensaje", nullable = false, length = 255)
    private String mensaje;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipo_notificacion_id_tipo_notificacion", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private TipoNotificacion tipoNotificacion;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cita_id_cita", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private Cita cita;

}
