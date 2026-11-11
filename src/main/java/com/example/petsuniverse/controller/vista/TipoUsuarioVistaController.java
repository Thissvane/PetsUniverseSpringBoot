package com.example.petsuniverse.controller.vista;

import org.springframework.ui.Model;
import com.example.petsuniverse.entity.TipoUsuario;
import com.example.petsuniverse.service.TipoUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/TipoUsuario")
public class TipoUsuarioVistaController {
    private final TipoUsuarioService service;

    public TipoUsuarioVistaController(TipoUsuarioService service) {
        this.service = service;
    }

    @GetMapping("/Listar")
    public String listar(Model model) {
        model.addAttribute("TipoUsuario", service.listar());
        return "TipoUsuario/TipoUsuario";
    }

    @GetMapping("/nuevo")
    public String nuevoTipoUsuario(Model model) {
        model.addAttribute("TipoUsuario", new TipoUsuario());
        return "";
    }

    @PostMapping("/guardar")
    public String insertarTipoUsuario(@ModelAttribute TipoUsuario tipoUsuario){
        service.insertar(tipoUsuario);
        return "redirect:/TipoUsuario/Listar";
    }
}
