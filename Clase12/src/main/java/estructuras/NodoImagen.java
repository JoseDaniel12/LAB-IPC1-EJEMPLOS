package estructuras;

import ipc1.clase12.Imagen;

/**
 *
 * @author josed
 */
public class NodoImagen {
    private Imagen imagen;
    private NodoImagen siguiente;
    private NodoImagen anterior;
    
    public NodoImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public NodoImagen(Imagen imagen, NodoImagen siguiente, NodoImagen anterior) {
        this.imagen = imagen;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Imagen getIamgen() {
        return imagen;
    }

    public void setIamgen(Imagen iamgen) {
        this.imagen = iamgen;
    }

    public NodoImagen getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoImagen siguiente) {
        this.siguiente = siguiente;
    }

    public NodoImagen getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoImagen anterior) {
        this.anterior = anterior;
    }
    
    
    
}
