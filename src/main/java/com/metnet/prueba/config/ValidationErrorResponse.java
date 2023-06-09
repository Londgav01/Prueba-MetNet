package com.metnet.prueba.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa una respuesta de validación de errores.
 * Contiene un mapa de campos y mensajes de error asociados.
 */
public class ValidationErrorResponse {

    //inicialización del mapa de campos y mensajes de error
    private Map<String, String> errores;

    /**
     * Constructor de la clase ValidationErrorResponse.
     * Inicializa el mapa de errores.
     */
    public ValidationErrorResponse() {
        this.errores = new HashMap<>();
    }

    /**
     * Agrega un nuevo error al mapa de errores.
     * @param field   Nombre del campo asociado al error.
     * @param message de error.
     */
    public void addError(String field, String message) {
        errores.put(field, message);
    }

    /**
     * Obtiene el mapa de errores.
     * @return Mapa de errores.
     */
    public Map<String, String> getErrors() {
        return errores;
    }
}

