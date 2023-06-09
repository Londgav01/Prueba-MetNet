package com.metnet.prueba.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//Clase Empleado la cual tiene diferentes atributos, esta es una entidad que va a la base de datos creando
// una tabla llamada Empleado
@Entity
@Table(name = "Empleado")
public class Empleado extends Persistence {

    // Atributo Id con anotaciones que le dan valor automatico y aleatorio, este atributo es la clave primaria del
    // objeto en la base de datos
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    //Atributos propios de clase

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La identificación es obligatoria")
    private String identificacion;

    private String direccion;

    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    private String telefono;

    /**
     * Constructor vacío
     */
    public Empleado() {}

    /**
     * Constructor con los parametros de la clase
     * @param nombre del empleado
     * @param identificacion del empleado
     * @param direccion del empleado
     * @param telefono del empleado
     */
    public Empleado(String nombre, String identificacion, String direccion, String telefono) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Metodos getters and setters para los diferentes atributos de clase

    /**
     * Obtiene el nombre del empleado.
     * @return el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * @param nombre el nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la identificación del empleado.
     * @return la identificación del empleado
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Establece la identificación del empleado.
     * @param identificacion la identificación del empleado
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * Obtiene la dirección del empleado.
     * @return la dirección del empleado
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del empleado.
     * @param direccion la dirección del empleado
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el teléfono del empleado.
     * @return el teléfono del empleado
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del empleado.
     * @param telefono el teléfono del empleado
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el ID del empleado.
     * @return el ID del empleado
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del empleado.
     * @param id el ID del empleado
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Compara si dos objetos Empleado son iguales.
     * @param o el objeto a comparar
     * @return true si los objetos son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado)) return false;
        Empleado empleado = (Empleado) o;
        return getIdentificacion().equals(empleado.getIdentificacion());
    }

    /**
     * Genera el código hash del objeto Empleado.
     * @return el código hash del objeto
     */
    @Override
    public int hashCode() {
        return getIdentificacion().hashCode();
    }

    /**
     * Devuelve una representación en cadena de texto del objeto Empleado.
     * @return una cadena de texto que representa el objeto
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
