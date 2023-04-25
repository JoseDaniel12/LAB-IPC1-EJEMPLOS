/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ipc1.clase13;

import estructuras.Pila;

/**
 *
 * @author josed
 */
public class Clase13 {
    
    public static int[][] matris = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    public static void imprimirMatris(int[][] matris) {
        int filas = matris.length; // 3
        int columnas = matris[0].length; // 3
        
        for (int y = 0; y < filas; y++) {
            for (int x = 0; x < columnas; x++) {
                System.out.print(matris[y][x] + " ");    
            }
            System.out.println("");
        }
    }
    
    public static int[][] invertirEjeVertical(int[][] matris) {
        int filas = matris.length; // 3
        int columnas = matris[0].length; //3
        int[][] matrisResultante = new int[filas][columnas];
        
        for (int y = 0; y < filas; y++) {
            for (int x = 0; x < columnas; x ++) {
                matrisResultante[y][x] = matris[y][columnas - x - 1];
            }
        }
        return matrisResultante;
    }
    

    public static void main(String[] args) {
        imprimirMatris(matris);
        System.out.println("---------");
        matris = invertirEjeVertical(matris);
        imprimirMatris(matris);
        
        
        /*
        Pila pila = new Pila();
        Imagen i1 = new Imagen("imagen1");
        Imagen i2 = new Imagen("imagen2");
        Imagen i3 = new Imagen("imagen3");
        pila.add(i1);
        pila.add(i2);
        pila.add(i3);
        Imagen imagenEliminada = (Imagen)pila.pop();
        System.out.println(imagenEliminada.nombre);
        imagenEliminada = (Imagen)pila.pop();
        System.out.println(imagenEliminada.nombre);
        */
        
        
        
    }
}
