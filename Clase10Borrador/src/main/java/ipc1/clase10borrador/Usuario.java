package ipc1.clase10borrador;

import java.io.Serializable;

/**
 *
 * @author josed
 */
public class Usuario implements Serializable {
    String nombre;
    String contrasenia;
    
    public Usuario(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Contrasenia: " + contrasenia;
    }
}

