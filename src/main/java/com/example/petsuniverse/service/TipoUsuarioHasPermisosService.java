package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.TipoUsuarioHasPermisos;
import com.example.petsuniverse.entity.TipoUsuarioHasPermisosId;
import com.example.petsuniverse.repository.TipoUsuarioHasPermisosRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link TipoUsuarioHasPermisos}.
 */
@Service
public class TipoUsuarioHasPermisosService extends CrudService<TipoUsuarioHasPermisos, TipoUsuarioHasPermisosId> {

    public TipoUsuarioHasPermisosService(TipoUsuarioHasPermisosRepository repository) {
        super(repository);
    }

    /** Guarda la relación y la devuelve con sus asociaciones cargadas. */
    @Override
    public TipoUsuarioHasPermisos guardar(TipoUsuarioHasPermisos entidad) {
        TipoUsuarioHasPermisos guardado = super.guardar(entidad);
        return repository.findById(guardado.getId()).orElse(guardado);
    }
}
