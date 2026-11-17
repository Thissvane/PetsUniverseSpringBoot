package com.example.petsuniverse.controller;

import com.example.petsuniverse.entity.Usuario;
import com.example.petsuniverse.service.TipoDocumentoService;
import com.example.petsuniverse.service.TipoUsuarioService;
import com.example.petsuniverse.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador de vistas (Thymeleaf) de {@link Usuario}: {@code /usuario}.
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private static final String VISTA_LISTA = "Usuario/Usuario";
    private static final String VISTA_FORMULARIO = "Usuario/NuevoUsuario";
    private static final String REDIRECCION = "redirect:/usuario";

    private final UsuarioService service;
    private final TipoDocumentoService tipoDocumentoService;
    private final TipoUsuarioService tipoUsuarioService;

    public UsuarioController(UsuarioService service, TipoDocumentoService tipoDocumentoService, TipoUsuarioService tipoUsuarioService) {
        this.service = service;
        this.tipoDocumentoService = tipoDocumentoService;
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return VISTA_LISTA;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("objeto", new Usuario());
        cargarListas(model);
        return VISTA_FORMULARIO;
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model, RedirectAttributes redirect) {
        return service.buscarPorId(id).map(objeto -> {
            model.addAttribute("objeto", objeto);
            cargarListas(model);
            return VISTA_FORMULARIO;
        }).orElseGet(() -> {
            redirect.addFlashAttribute("error", "El registro solicitado no existe.");
            return REDIRECCION;
        });
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("objeto") Usuario objeto, BindingResult result,
                          Model model, RedirectAttributes redirect) {
        if (objeto.getIdUsuario() == null
                && (objeto.getClave() == null || objeto.getClave().isBlank())) {
            result.rejectValue("clave", "NotBlank", "La clave es obligatoria.");
        }
        if (objeto.getTipoDocumento() == null || objeto.getTipoDocumento().getIdTipoDocumento() == null) {
            result.rejectValue("tipoDocumento.idTipoDocumento", "NotNull", "Seleccione una opción.");
        }
        if (objeto.getTipoUsuario() == null || objeto.getTipoUsuario().getIdTipoUsuario() == null) {
            result.rejectValue("tipoUsuario.idTipoUsuario", "NotNull", "Seleccione una opción.");
        }
        if (result.hasErrors()) {
            cargarListas(model);
            return VISTA_FORMULARIO;
        }
        try {
            service.guardar(objeto);
        } catch (DataIntegrityViolationException ex) {
            model.addAttribute("error", "No fue posible guardar: hay un dato duplicado o inválido.");
            cargarListas(model);
            return VISTA_FORMULARIO;
        }
        redirect.addFlashAttribute("mensaje", "Registro guardado correctamente.");
        return REDIRECCION;
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes redirect) {
        try {
            service.eliminar(id);
            redirect.addFlashAttribute("mensaje", "Registro eliminado correctamente.");
        } catch (DataIntegrityViolationException ex) {
            redirect.addFlashAttribute("error", "No se puede eliminar: el registro está relacionado con otros datos.");
        }
        return REDIRECCION;
    }

    private void cargarListas(Model model) {
        model.addAttribute("tiposDocumento", tipoDocumentoService.listar());
        model.addAttribute("tiposUsuario", tipoUsuarioService.listar());
    }
}
