# PetsUniverse (Spring Boot)

Sistema de gestión veterinaria. Migración a Spring Boot (Maven, Java 17, Spring Data JPA, Thymeleaf, MySQL).

## Puesta en marcha

1. Ejecutar el script SQL original de PetsUniverse en MySQL (esquema `PetsUniverse`).
2. Ejecutar `docs/ajustes_bd.sql` (agrega `AUTO_INCREMENT` a `cita.id_cita`).
3. Revisar `src/main/resources/application.properties` (puerto `3307`, usuario `root` por defecto) o definir
   las variables `DB_URL`, `DB_USER` y `DB_PASSWORD`.
4. Ejecutar `PetsUniverseApplication` desde IntelliJ y abrir <http://localhost:8081/>.

## Arquitectura

`controller` (vistas Thymeleaf) · `controller.api` (REST) · `service` · `repository` · `entity`.
`CrudService` y `CrudApiController` concentran el CRUD común; cada entidad solo declara lo propio.

## Rutas

| Módulo | Vistas | API REST |
|---|---|---|
| Tipos de documento | `/tipo_documento` | `/api/tipo_documento` |
| Tipos de usuario | `/tipo_usuario` | `/api/tipo_usuario` |
| Usuarios | `/usuario` | `/api/usuario` |
| Especies | `/especie` | `/api/especie` |
| Razas | `/raza` | `/api/raza` |
| Mascotas | `/mascota` | `/api/mascota` |
| Veterinarios | `/veterinario` | `/api/veterinario` |
| Disponibilidades | `/disponibilidad` | `/api/disponibilidad` |
| Estados de cita | `/estado_cita` | `/api/estado_cita` |
| Tipos de servicio | `/tipo_servicio` | `/api/tipo_servicio` |
| Tipos de notificación | `/tipo_notificacion` | `/api/tipo_notificacion` |
| Servicios | `/servicio` | `/api/servicio` |
| Citas | `/cita` | `/api/cita` |
| Notificaciones | `/notificacion` | `/api/notificacion` |
| Permisos | `/permisos` | `/api/permisos` |
| TipoUsuarioHasPermisos | — | `/api/tipo_usuario_has_permisos` |
| VeterinarioHasDisponibilidad | — | `/api/veterinario_has_disponibilidad` |

Rutas REST comunes: `GET /listar`, `GET /{id}`, `POST /guardar` (crea o actualiza según el `id`) y
`DELETE /eliminar/{id}`. Las tablas de unión se gestionan solo por API; su clave compuesta se envía en `id`
(por ejemplo `{"id": {"tipoUsuarioId": 3, "permisosId": 1}}`) y se elimina con
`DELETE /api/tipo_usuario_has_permisos/eliminar/{tipoUsuarioId}/{permisosId}`.

## Notas

- La clave de `usuario` se almacena con BCrypt y no se expone en las respuestas JSON.
- `spring.jpa.hibernate.ddl-auto=validate`: si Hibernate reporta una diferencia de tipos con el esquema,
  puede cambiarse temporalmente a `none`.
- La tabla `Permisos_has_Tipo_usuario` (duplicada) no se mapea; ver `docs/ajustes_bd.sql`.
