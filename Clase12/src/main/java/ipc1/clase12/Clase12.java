/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ipc1.clase12;

import estructuras.ListaDoble;

/**
 *
 * @author josed
 */
public class Clase12 {

    public static void main(String[] args) {
        System.out.println("------------------ Lista Doble --------------------");
        ListaDoble listaDoble = new ListaDoble();
        Imagen i1 = new Imagen("imagen1");
        Imagen i2 = new Imagen("imagen2");
        Imagen i3 = new Imagen("imagen3");
        listaDoble.add(i1);
        listaDoble.add(i2);
        //listaDoble.add(i3);
        listaDoble.imprimirLista();
        //System.out.println( ((Imagen)listaDoble.find("imagen1")).getNombre());
        //System.out.println( ((Imagen)listaDoble.get(-1)).getNombre());
        
        listaDoble.delete("imagen2");
        listaDoble.imprimirLista();
    }
}
