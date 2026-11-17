package com.example.petsuniverse.controller;

import com.example.petsuniverse.entity.TipoNotificacion;
import com.example.petsuniverse.service.TipoNotificacionService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador de vistas (Thymeleaf) de {@link TipoNotificacion}: {@code /tipo_notificacion}.
 */
@Controller
@RequestMapping("/tipo_notificacion")
public class TipoNotificacionController {

    private static final String VISTA_LISTA = "TipoNotificacion/TipoNotificacion";
    private static final String VISTA_FORMULARIO = "TipoNotificacion/NuevoTipoNotificacion";
    private static final String REDIRECCION = "redirect:/tipo_notificacion";

    private final TipoNotificacionService service;

    public TipoNotificacionController(TipoNotificacionService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return VISTA_LISTA;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("objeto", new TipoNotificacion());
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
    public String guardar(@Valid @ModelAttribute("objeto") TipoNotificacion objeto, BindingResult result,
                          Model model, RedirectAttributes redirect) {
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
        // Sin listas de apoyo para este formulario.
    }
}
