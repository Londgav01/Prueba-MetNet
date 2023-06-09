package com.metnet.prueba.services;

import com.metnet.prueba.exceptions.EmpleadoException;
import com.metnet.prueba.models.Empleado;
import com.metnet.prueba.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase que proporciona servicios relacionados con la entidad Empleado.
 */
@Service
public class EmpleadoService {

    //instancia de la base de datos de empleados
    private final EmpleadoRepository empleadoRepository;

    /**
     * Constructor de EmpleadoService.
     * @param empleadoRepository de Empleado utilizado para acceder a los datos.
     */
    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    /**
     * Obtiene todos los empleados.
     * @return una lista de empleados.
     */
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    /**
     * Obtiene un empleado por su identificador.
     * @param id del empleado.
     * @return el empleado correspondiente al identificador.
     * @throws EmpleadoException si no se encuentra ningún empleado con el identificador especificado.
     */
    public Empleado obtenerPorId(Long id) throws EmpleadoException {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        return empleadoOptional.orElseThrow(() -> new EmpleadoException("Empleado no encontrado"));
    }

    /**
     * Guarda un nuevo empleado o actualiza un empleado existente.
     * @param empleado a guardar o actualizar.
     * @return el empleado guardado o actualizado.
     */
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    /**
     * Método que elimina un empleado por su identificador.
     * @param id del empleado a eliminar.
     */
    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }
}


