package estructuras;

import ipc1.borradorclase12.Imagen;
import java.util.NoSuchElementException;

/**
 *
 * @author josed
 */
public class Pila extends EstructuraDeDatos {
    private NodoImagen tope;
    
    public void listarNombres() {
        if (tope == null) {
            return;
        }
        
        NodoImagen nodoAuxiliar = tope;
        while (nodoAuxiliar != null) {
            System.out.print(nodoAuxiliar.getImagen().nombre + " -> ");
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        System.out.print("null \n");
    } 

    @Override
    public void add(Object e) {
        Imagen imagen = (Imagen)e;
        NodoImagen nuevoNodo = new NodoImagen(imagen);
        if (tope  == null) {
            tope = nuevoNodo;
        } else {
           nuevoNodo.setSiguiente(tope);
           tope = nuevoNodo;
        }
        index++;
    }

    @Override
    public Object peek() {
        if (tope == null) {
            return new NoSuchElementException();
        }
        Imagen imagen = tope.getImagen();
        return imagen;
    }

    @Override
    public Object find(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getSize() {
        return index;
    } 

    @Override
    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object pop() {
        if (tope == null) {
            throw new NoSuchElementException();
        }
        
        Imagen imagen = tope.getImagen();
        tope = tope.getSiguiente();
        index--;
        return imagen;
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
