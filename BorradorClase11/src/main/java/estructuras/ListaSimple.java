package estructuras;

import ipc1.borradorclase11.Usuario;

/**
 *
 * @author josed
 */
public class ListaSimple extends EstructuraDeDatos {

    private NodoUsuario cabeza = null;
    
    @Override
    public void add(Object e) {
        Usuario usuario = (Usuario)e;
        NodoUsuario nodoUsuario = new NodoUsuario(usuario);
        
        // Si el usuario ya existia en la lista no se hace nada
        if (find(usuario.nombre) != null) {
            return;
        }
        
        if (getSize() == 0) {
            // Si no existia y esta vacia entonces sera la cabeza
            cabeza = nodoUsuario;
        } else {
            // Si no existia y ya hay elemetos en la lista se inserta de ultimo
            NodoUsuario nodoAuxiliar = cabeza;
            while (nodoAuxiliar.getSiguiente() != null) {
                nodoAuxiliar = nodoAuxiliar.getSiguiente();
            }
            nodoAuxiliar.setSiguiente(nodoUsuario);
        }
        index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object nombreUsuario) {
        NodoUsuario nodoAuxiliar = cabeza;
        for (int i = 0; i < index; i++) {
            if (nodoAuxiliar.getUsuario().nombre.equals(nombreUsuario.toString())) {
               return nodoAuxiliar.getUsuario();
            }
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return null;
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getSize() {
        if (cabeza == null) {
            return 0;
        }
        return index + 1;
    }

    @Override
    public Object get(int i) {
        // Si se coloca un indice fuera de los limtes se regresa null
        if (i < 0 || i >= index) {
            throw new IllegalArgumentException("Indice fuera de los limites.");
        }
        
        NodoUsuario nodoAuxiliar = cabeza;
        for (int contador = 0; contador < i; contador++) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return nodoAuxiliar.getUsuario();
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
