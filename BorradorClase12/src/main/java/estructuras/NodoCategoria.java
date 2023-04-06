package estructuras;

import ipc1.borradorclase12.Categoria;

/**
 *
 * @author josed
 */
public class NodoCategoria {
    private Categoria categoria;
    private NodoCategoria anterior;
    private NodoCategoria siguiente;

    public NodoCategoria(Categoria categoria, NodoCategoria anterior, NodoCategoria siguiente) {
        this.categoria = categoria;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }
    
    public NodoCategoria(Categoria categoria) {
        this(categoria, null, null);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public NodoCategoria getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCategoria anterior) {
        this.anterior = anterior;
    }

    public NodoCategoria getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCategoria siguiente) {
        this.siguiente = siguiente;
    }
}
