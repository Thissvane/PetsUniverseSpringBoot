package com.example.petsuniverse.controller;

import com.example.petsuniverse.entity.Mascota;
import com.example.petsuniverse.service.MascotaService;
import com.example.petsuniverse.service.RazaService;
import com.example.petsuniverse.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador de vistas (Thymeleaf) de {@link Mascota}: {@code /mascota}.
 */
@Controller
@RequestMapping("/mascota")
public class MascotaController {

    private static final String VISTA_LISTA = "Mascota/Mascota";
    private static final String VISTA_FORMULARIO = "Mascota/NuevoMascota";
    private static final String REDIRECCION = "redirect:/mascota";

    private final MascotaService service;
    private final UsuarioService usuarioService;
    private final RazaService razaService;

    public MascotaController(MascotaService service, UsuarioService usuarioService, RazaService razaService) {
        this.service = service;
        this.usuarioService = usuarioService;
        this.razaService = razaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return VISTA_LISTA;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("objeto", new Mascota());
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
    public String guardar(@Valid @ModelAttribute("objeto") Mascota objeto, BindingResult result,
                          Model model, RedirectAttributes redirect) {
        if (objeto.getUsuario() == null || objeto.getUsuario().getIdUsuario() == null) {
            result.rejectValue("usuario.idUsuario", "NotNull", "Seleccione una opción.");
        }
        if (objeto.getRaza() == null || objeto.getRaza().getIdRaza() == null) {
            result.rejectValue("raza.idRaza", "NotNull", "Seleccione una opción.");
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
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("razas", razaService.listar());
    }
}
