package com.example.petsuniverse.service;

import com.example.petsuniverse.entity.TipoDocumento;
import com.example.petsuniverse.repository.TipoDocumentoRepository;
import org.springframework.stereotype.Service;

/**
 * Lógica de negocio de {@link TipoDocumento}.
 */
@Service
public class TipoDocumentoService extends CrudService<TipoDocumento, Integer> {

    public TipoDocumentoService(TipoDocumentoRepository repository) {
        super(repository);
    }
}
