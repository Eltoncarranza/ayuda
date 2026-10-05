package cibertec.pe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SaludoController {
    @GetMapping("/saludo")
    public String Saludo() {return "Bienvenido";}
}
