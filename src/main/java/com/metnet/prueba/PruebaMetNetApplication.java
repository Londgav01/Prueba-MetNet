package com.metnet.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación PruebaMetNet.
 * La anotación @SpringBootApplication indica que esta clase es una aplicación Spring Boot.
 */
@SpringBootApplication
public class PruebaMetNetApplication {

    /**
     * Método principal que inicia la aplicación.
     * @param args los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SpringApplication.run(PruebaMetNetApplication.class, args);
    }

}
