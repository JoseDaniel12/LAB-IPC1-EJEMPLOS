package estructuras;

import ipc1.borradorclase12.Imagen;
import java.util.NoSuchElementException;

/**
 *
 * @author josed
 */
public class Cola extends EstructuraDeDatos {
    private NodoImagen primero; // Nodo agregado primero
    private NodoImagen ultimo;  // Nodo agregado mas rencientemente
    
    public void listarNombres() {
        if (primero == null) {
            return;
        }
        
        NodoImagen nodoAuxiliar = primero;
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
        if (primero == null) {
            primero = ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        index++;
    }

    @Override
    public Object peek() {
        return primero.getImagen();
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
        if (primero == null) {
            throw new NoSuchElementException();
        }
        
        Imagen imagen = primero.getImagen();
        primero = primero.getSiguiente();
        if (primero == null) {
            ultimo = null;
        }
        index--;
        return imagen;
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
 