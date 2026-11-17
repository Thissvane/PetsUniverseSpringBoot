package com.example.petsuniverse.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entidad que mapea la tabla {@code usuario}.
 */
@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @NotBlank(message = "Nombre: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @NotBlank(message = "Apellido: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;

    @NotNull(message = "Fecha de nacimiento: campo obligatorio.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @NotBlank(message = "Número de documento: campo obligatorio.")
    @Size(max = 20, message = "Máximo 20 caracteres.")
    @Column(name = "num_documento", nullable = false, length = 20)
    private String numDocumento;

    @NotBlank(message = "Teléfono: campo obligatorio.")
    @Size(max = 10, message = "Máximo 10 caracteres.")
    @Column(name = "num_telefono", nullable = false, length = 10)
    private String numTelefono;

    @NotBlank(message = "Correo electrónico: campo obligatorio.")
    @Size(max = 45, message = "Máximo 45 caracteres.")
    @Email(message = "Correo electrónico no válido.")
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Size(max = 255, message = "Máximo 255 caracteres.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "clave", nullable = false, length = 255)
    private String clave;

    @NotNull(message = "Vencimiento de la clave: campo obligatorio.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_vencimiento_clave", nullable = false)
    private LocalDate fechaVencimientoClave;

    @NotNull(message = "Autoriza tratamiento de datos: campo obligatorio.")
    @Column(name = "autorizacion_datos", nullable = false, columnDefinition = "TINYINT")
    private Boolean autorizacionDatos;

    @NotNull(message = "Activo: campo obligatorio.")
    @Column(name = "estado", nullable = false, columnDefinition = "TINYINT")
    private Boolean estado;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipo_documento_id_tipo_documento", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private TipoDocumento tipoDocumento;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipo_usuario_id_tipo_usuario", nullable = false)
    @NotNull(message = "Seleccione una opción.")
    private TipoUsuario tipoUsuario;

}
