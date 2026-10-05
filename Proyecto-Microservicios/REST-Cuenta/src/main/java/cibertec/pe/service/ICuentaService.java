package cibertec.pe.service;

import cibertec.pe.model.Cuenta;

import java.util.List;

public interface ICuentaService {
    public List<Cuenta> listAllCuenta();
    public String       createCuenta(Cuenta cuenta);
}
