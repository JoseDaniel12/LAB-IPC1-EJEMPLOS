package estructuras;

import ipc1.clase13.Imagen;

/**
 *
 * @author josed
 */
public class NodoImagen {
    private Imagen imagen;
    private NodoImagen siguiente; // apunta al elemento agregado anteriormente

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
