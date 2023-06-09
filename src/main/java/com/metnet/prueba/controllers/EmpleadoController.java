package com.metnet.prueba.controllers;

import com.metnet.prueba.config.ValidationErrorResponse;
import com.metnet.prueba.exceptions.EmpleadoException;
import com.metnet.prueba.models.Empleado;
import com.metnet.prueba.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controlador para la gestión de los empleados.
 */
@RestController
@RequestMapping("/empleados")
@Valid
public class EmpleadoController {

    //instancia de empleadosService
    private final EmpleadoService empleadoService;

    /**
     * "Contructor" de la clase donde se le aplica la anotacion para que Spring pueda leer y encontrar la referencia
     * @param empleadoService
     */
    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    /**
     * Obtiene todos los empleados.
     * @return Lista de empleados
     */
    @GetMapping
    public List<Empleado> obtenerTodos() {
        return empleadoService.obtenerTodos();
    }

    /**
     * Obtiene un empleado por su identificador.
     * @param id del empleado
     * @return Empleado encontrado
     * @throws EmpleadoException si el empleado no existe
     */
    @GetMapping("/{id}")
    public Empleado obtenerPorId(@PathVariable Long id) throws EmpleadoException {
        return empleadoService.obtenerPorId(id);
    }

    /**
     * Guarda un nuevo empleado.
     * @param empleado a guardar
     * @return Empleado guardado
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado guardar(@RequestBody @Valid Empleado empleado) {
        return empleadoService.guardar(empleado);
    }

    /**
     * Metodo que actualiza un empleado existente.
     * @param id del empleado a actualizar
     * @param empleado con los nuevos datos
     * @return Empleado actualizado
     */
    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Long id, @RequestBody @Valid Empleado empleado) {
        empleado.setId(id);
        return empleadoService.guardar(empleado);
    }

    /**
     * Elimina un empleado por su identificador.
     * @param id Identificador del empleado a eliminar
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
    }

    /**
     * Maneja las excepciones de validación de los campos del empleado.
     * @param ex Excepción de validación
     * @return Objeto ValidationErrorResponse con los errores de validación
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        ValidationErrorResponse errorResponse = new ValidationErrorResponse();
        fieldErrors.forEach(fieldError -> errorResponse.addError(fieldError.getField(), fieldError.getDefaultMessage()));

        return errorResponse;
    }

}

