package estructuras;

import ipc1.borradorclase12.Categoria;

/**
 *
 * @author josed
 */
public class ListaDoble extends EstructuraDeDatos {
    NodoCategoria primerNodo;
    NodoCategoria ultimoNodo;
    
    public void listarNombres() {
        if (primerNodo == null) {
            return;
        }
        
        NodoCategoria nodoAuxiliar = primerNodo;
        while (nodoAuxiliar != null) {
            System.out.print(nodoAuxiliar.getCategoria().nombre + " -> ");
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }     
        System.out.print("null \n");
    }  
    
    @Override
    public void add(Object e) {
        Categoria categoria = (Categoria)e;
        if (primerNodo == null) {
            primerNodo = ultimoNodo = new NodoCategoria(categoria);
        } else {
            NodoCategoria nuevoNodo = new NodoCategoria(categoria, ultimoNodo, null);
            ultimoNodo.setSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }
        index++;
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object e) {
        if (primerNodo == null) {
            return null;
        }
        
        String nombreCategoria = e.toString();
        NodoCategoria nodoAuxiliar = primerNodo; 
        for (int i = 0; i < getSize(); i++) {
            if (nodoAuxiliar.getCategoria().nombre.equals(nombreCategoria)) {
                return nodoAuxiliar.getCategoria();
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
        return index;
    }

    @Override
    public Object get(int i) {
        if (i < 0  || i > index) {
            return new IndexOutOfBoundsException();
        }
        
        NodoCategoria nodoAuxiliar = primerNodo;
        for (int contador = 0; contador < i; contador++) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        return nodoAuxiliar.getCategoria();
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object e) {
        String nombreCategoria = e.toString();
        NodoCategoria nodoAuxiliar = primerNodo;
        while (nodoAuxiliar != null && !nodoAuxiliar.getCategoria().nombre.equals(nombreCategoria)) {
            nodoAuxiliar = nodoAuxiliar.getSiguiente();
        }
        
        if (nodoAuxiliar == null) {
            return;
        } else if (nodoAuxiliar == primerNodo) {
            primerNodo = primerNodo.getSiguiente();
            primerNodo.setAnterior(null);
        } else if (nodoAuxiliar == ultimoNodo) {
            ultimoNodo = ultimoNodo.getAnterior();
            ultimoNodo.setSiguiente(null);
        } else {
            nodoAuxiliar.getAnterior().setSiguiente(nodoAuxiliar.getSiguiente());
            nodoAuxiliar.getSiguiente().setAnterior(nodoAuxiliar.getAnterior());
        }
        index--;
    }
}
