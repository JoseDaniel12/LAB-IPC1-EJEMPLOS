package ipc1.clase7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;

/**
 *
 * @author josed
 */
public class ContenedorImagen {
    public String nombre;
    ImageIcon imagen;
    String fecha;
    
    
    public ContenedorImagen(String nombre, ImageIcon imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        
        // Fecha en que se cargo la imagen
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        this.fecha = fechaHoraActual.format(formato);
    }
}
