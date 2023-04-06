package ipc1.borradorclase12;

import estructuras.Cola;
import estructuras.ListaDoble;
import estructuras.Pila;


/**
 *
 * @author josed
 */
public class BorradorClase12 {

    public static void main(String[] args) {
        /*
        System.out.println("---------- Cola ----------");
        Cola cola = new Cola();
        Imagen i1 = new Imagen("imagen1");
        Imagen i2 = new Imagen("imagen2");
        Imagen i3 = new Imagen("imagen3");
        cola.add(i1);
        cola.add(i2);
        cola.add(i3);
        cola.listarNombres();
        System.out.println("Peek: " + ((Imagen)cola.peek()).nombre);
        cola.listarNombres();
        System.out.println("Pop: " + ((Imagen)cola.pop()).nombre);
        cola.listarNombres();
        System.out.println("Size: " + cola.getSize());
        */
        
        /*
        System.out.println("---------- Pila ----------");
        Pila pila = new Pila();
        Imagen i1 = new Imagen("imagen1");
        Imagen i2 = new Imagen("imagen2");
        Imagen i3 = new Imagen("imagen3");
        pila.add(i1);
        pila.add(i2);
        pila.add(i3);
        pila.listarNombres();
        System.out.println("Peek: " + ((Imagen)pila.peek()).nombre);
        pila.listarNombres();
        System.out.println("Pop: " + ((Imagen)pila.pop()).nombre);
        pila.listarNombres();
        System.out.println("Size: " + pila.getSize());
        */
        
        System.out.println("---------- Lista Doble ----------");
        ListaDoble listaDoble = new ListaDoble();
        Categoria c1 = new Categoria("videojuegos");
        Categoria c2 = new Categoria("celulares");
        Categoria c3 = new Categoria("computadoras");
        
        System.out.println("Size: " + listaDoble.getSize());
        listaDoble.add(c1);
        listaDoble.add(c2);
        listaDoble.add(c3);
        listaDoble.listarNombres();
        listaDoble.delete("computadoras");
        listaDoble.listarNombres();
        System.out.println("Size: " + listaDoble.getSize());
        System.out.println(((Categoria)listaDoble.find("videojuegos")).nombre);
    }
}
