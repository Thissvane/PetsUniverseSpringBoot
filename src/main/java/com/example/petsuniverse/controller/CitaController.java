package com.example.petsuniverse.controller;

import com.example.petsuniverse.entity.Cita;
import com.example.petsuniverse.service.CitaService;
import com.example.petsuniverse.service.EstadoCitaService;
import com.example.petsuniverse.service.MascotaService;
import com.example.petsuniverse.service.ServicioService;
import com.example.petsuniverse.service.VeterinarioService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controlador de vistas (Thymeleaf) de {@link Cita}: {@code /cita}.
 */
@Controller
@RequestMapping("/cita")
public class CitaController {

    private static final String VISTA_LISTA = "Cita/Cita";
    private static final String VISTA_FORMULARIO = "Cita/NuevoCita";
    private static final String REDIRECCION = "redirect:/cita";

    private final CitaService service;
    private final MascotaService mascotaService;
    private final ServicioService servicioService;
    private final EstadoCitaService estadoCitaService;
    private final VeterinarioService veterinarioService;

    public CitaController(CitaService service, MascotaService mascotaService, ServicioService servicioService, EstadoCitaService estadoCitaService, VeterinarioService veterinarioService) {
        this.service = service;
        this.mascotaService = mascotaService;
        this.servicioService = servicioService;
        this.estadoCitaService = estadoCitaService;
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("lista", service.listar());
        return VISTA_LISTA;
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("objeto", new Cita());
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
    public String guardar(@Valid @ModelAttribute("objeto") Cita objeto, BindingResult result,
                          Model model, RedirectAttributes redirect) {
        if (objeto.getMascota() == null || objeto.getMascota().getIdMascota() == null) {
            result.rejectValue("mascota.idMascota", "NotNull", "Seleccione una opción.");
        }
        if (objeto.getServicio() == null || objeto.getServicio().getIdServicio() == null) {
            result.rejectValue("servicio.idServicio", "NotNull", "Seleccione una opción.");
        }
        if (objeto.getEstadoCita() == null || objeto.getEstadoCita().getIdEstadoCita() == null) {
            result.rejectValue("estadoCita.idEstadoCita", "NotNull", "Seleccione una opción.");
        }
        if (objeto.getVeterinario() == null || objeto.getVeterinario().getIdVeterinario() == null) {
            result.rejectValue("veterinario.idVeterinario", "NotNull", "Seleccione una opción.");
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
        model.addAttribute("mascotas", mascotaService.listar());
        model.addAttribute("servicios", servicioService.listar());
        model.addAttribute("estadosCita", estadoCitaService.listar());
        model.addAttribute("veterinarios", veterinarioService.listar());
    }
}
