package com.example.petsuniverse.controller.api;

import com.example.petsuniverse.entity.TipoDocumento;
import com.example.petsuniverse.service.TipoDocumentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API REST de {@link TipoDocumento}: {@code /api/tipo_documento}.
 */
@RestController
@RequestMapping("/api/tipo_documento")
public class TipoDocumentoApiController extends CrudApiController<TipoDocumento> {

    public TipoDocumentoApiController(TipoDocumentoService service) {
        super(service);
    }
}
