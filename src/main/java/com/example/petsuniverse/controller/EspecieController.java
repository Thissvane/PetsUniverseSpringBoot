package com.example.petsuniverse.controller;

import com.example.petsuniverse.entity.Especie;
import com.example.petsuniverse.service.EspecieService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador de vistas (Thymeleaf) de {@link Especie}: {@code /especie}.
 */
@Controller
@RequestMapping("/especie")
public class EspecieController {

    private static final String VISTA_LISTA = "Especie/Especie";
    private static final String VISTA_FORMULARIO = "Especie/NuevoEspecie";
    private static final String REDIRECCION = "redirect:/especie";

    private final EspecieService service;

    public EspecieController(EspecieService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return VISTA_LISTA;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("objeto", new Especie());
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
    public String guardar(@Valid @ModelAttribute("objeto") Especie objeto, BindingResult result,
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
