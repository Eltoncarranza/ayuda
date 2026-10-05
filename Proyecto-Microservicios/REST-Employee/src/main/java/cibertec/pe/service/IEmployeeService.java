package cibertec.pe.service;

import cibertec.pe.entity.Cuenta;
import cibertec.pe.model.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee>   listAllEmployee();
    public String           createEmployee(Employee employee);

    public String           createCuenta(Cuenta cuenta, int codigo);
}
