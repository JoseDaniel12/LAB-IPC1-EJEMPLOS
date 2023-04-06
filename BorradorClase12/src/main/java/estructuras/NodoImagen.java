package estructuras;

import ipc1.borradorclase12.Imagen;
import javax.swing.ImageIcon;

/**
 *
 * @author josed
 */
public class NodoImagen {
    // Solo como ejemplo
    public Imagen imagen;
    private NodoImagen siguiente;
    
    public NodoImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
    
    public NodoImagen getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoImagen siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
