package cibertec.pe.controller;


import cibertec.pe.entity.Cuenta;
import cibertec.pe.model.Employee;
import cibertec.pe.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService servEmployee;

    @GetMapping("/listEmployees")
    public List<Employee> listarEmpleados()
    {
        return servEmployee.listAllEmployee();
    }

    @PostMapping("/createEmployee")
    public String crearEmpleado(@RequestBody Employee employee)
    {
        return servEmployee.createEmployee(employee);
    }

    @PostMapping("/crearCuenta/{codigo}")
    public String crearCuenta(@PathVariable int codigo, @RequestBody Cuenta cuenta){
        return servEmployee.createCuenta(cuenta, codigo);
    }
}
