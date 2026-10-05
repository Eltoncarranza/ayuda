package cibertec.pe.feignclient;

import cibertec.pe.entity.Cuenta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// La url es en base a REST-Cuenta
@FeignClient(name = "Rest-Cuenta-FeignClient", url = "http://localhost:9004")
public interface ICuentaFeignClient {
    @PostMapping("/api/cuenta/crearCuenta")
    public String crearCuenta(@RequestBody Cuenta cuenta);
}
