package cibertec.pe.repository;

import cibertec.pe.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepository extends JpaRepository<Cuenta, Integer>
{

}
