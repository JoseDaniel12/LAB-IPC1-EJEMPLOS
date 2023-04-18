package ipc1.clase12;

import javax.swing.ImageIcon;

/**
 *
 * @author josed
 */
public class Imagen {
    public String nombre;
    public ImageIcon imageIcon;
    
    public Imagen(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
        
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
