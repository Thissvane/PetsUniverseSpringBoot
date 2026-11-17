package com.example.petsuniverse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Página de inicio con el acceso a los módulos.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}
