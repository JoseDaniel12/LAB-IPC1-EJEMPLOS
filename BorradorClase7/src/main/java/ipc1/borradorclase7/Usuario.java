package ipc1.borradorclase7;

import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author josed
 */
public class Usuario {
    String nombreUsuario;
    String contrasenia;
    String fechaNacimiento;
    String genero;
    LinkedList<ContenedorImagen> imagenes = new LinkedList<>();
    
    public Usuario(String nombreUsuario, String contrasenia, String fechaNacimiento, String genero) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }
    
    public int agregarFoto(ContenedorImagen contenedorImagen) {
        this.imagenes.add(contenedorImagen);
        return this.imagenes.size();
    }
}
