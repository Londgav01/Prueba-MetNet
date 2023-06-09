package com.metnet.prueba.exceptions;

//Clase exception

/**
 * Excepción personalizada para errores relacionados con la entidad Empleado.
 */
public class EmpleadoException extends Exception {

    /**
     * Crea una nueva instancia de EmpleadoException con el mensaje de error especificado.
     * @param message descriptivo de la exception
     */
    public EmpleadoException(String message) {
        super(message);
    }
}
