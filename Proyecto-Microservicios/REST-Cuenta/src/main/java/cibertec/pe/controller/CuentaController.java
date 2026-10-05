package cibertec.pe.controller;

import cibertec.pe.model.Cuenta;
import cibertec.pe.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {
    @Autowired
    ICuentaService serviceCta;

    @GetMapping("/listCuenta")
    public List<Cuenta> listarCuenta() {
        return serviceCta.listAllCuenta();
    }

    @PostMapping("/crearCuenta")
    public String crearCuenta(@RequestBody Cuenta cuenta) {
        return serviceCta.createCuenta(cuenta);
    }
}
