package cibertec.pe.service;

import cibertec.pe.entity.Cuenta;
import cibertec.pe.feignclient.ICuentaFeignClient;
import cibertec.pe.model.Employee;
import cibertec.pe.rabbit.RabbitMQConfig;
import cibertec.pe.repository.IEmployeeRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImplement implements IEmployeeService {
    @Autowired
    private IEmployeeRepository repoEmployee;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ICuentaFeignClient ctaFeign;

    @Override
    public List<Employee> listAllEmployee() {
        return repoEmployee.findAll();
    }

    @Override
    public String createEmployee(Employee employee) {
        repoEmployee.save(employee);

        String mensaje = "Nuevo Empleado con ID: " + employee.getCod_Empl()
                + "y nombre: " + employee.getNom_Empl();

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, mensaje);

        return "Empleado creado";
    }

    @Override
    public String createCuenta(Cuenta cuenta, int codigo) {
        cuenta.setCod_Empl(codigo);
        return ctaFeign.crearCuenta(cuenta);
    }
}
