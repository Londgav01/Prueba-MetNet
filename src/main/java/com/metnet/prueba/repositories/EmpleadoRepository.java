package com.metnet.prueba.repositories;

import com.metnet.prueba.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interfaz repositorio de la clase empleado (union con la DB).
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
