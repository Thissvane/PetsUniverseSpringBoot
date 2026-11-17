package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.VeterinarioHasDisponibilidad;
import com.example.petsuniverse.entity.VeterinarioHasDisponibilidadId;
import com.example.petsuniverse.repository.VeterinarioHasDisponibilidadRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link VeterinarioHasDisponibilidad}.
 */
@Service
public class VeterinarioHasDisponibilidadService extends CrudService<VeterinarioHasDisponibilidad, VeterinarioHasDisponibilidadId> {

    public VeterinarioHasDisponibilidadService(VeterinarioHasDisponibilidadRepository repository) {
        super(repository);
    }

    /** Guarda la relación y la devuelve con sus asociaciones cargadas. */
    @Override
    public VeterinarioHasDisponibilidad guardar(VeterinarioHasDisponibilidad entidad) {
        VeterinarioHasDisponibilidad guardado = super.guardar(entidad);
        return repository.findById(guardado.getId()).orElse(guardado);
    }
}
