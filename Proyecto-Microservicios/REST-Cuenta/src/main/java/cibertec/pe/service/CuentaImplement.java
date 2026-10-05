package cibertec.pe.service;

import cibertec.pe.model.Cuenta;
import cibertec.pe.repository.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaImplement implements ICuentaService {

    @Autowired
    ICuentaRepository repoCta;

    @Override
    public List<Cuenta> listAllCuenta() {
        return repoCta.findAll();
    }

    @Override
    public String createCuenta(Cuenta cuenta) {
        repoCta.save(cuenta);
        return "Cuenta creada";
    }
}
