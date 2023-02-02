package ipc1.clase2;

import java.util.Scanner;

/**
 *
 * @author josed
 */

class Mascota {
    String nombre;
    int edad;
}

class Producto {
    int vecesComprado = 0;
}


public class Clase2 {
    public static Scanner scannerNumerico = new Scanner(System.in);
    public static Scanner scannerDeCadenas = new Scanner(System.in);
    
    public static Mascota[] mascotas = new Mascota[100];
    
    public static void menuPrencipal() {
        int opcion = 0;
        do {
            System.out.println("1. Registrar mascota.");
            System.out.println("2. Ver mascotas ordenadas por edad.");
            System.out.println("3. Salir.");
            System.out.print("Ingrese una opción: ");
            opcion = scannerNumerico.nextInt();
            
            switch (opcion) {
                case 1: 
                    registrarMascota();
                    break;
                case 2:
                    mostrarMascotasOrdenadas();
                    break;
                default:
                    System.out.println("No ingresaste una opcion valida.");
                    
            }
        } while (opcion != 3);
    }
    
    public static void registrarMascota() {
        System.out.println("Ingrese nombre de mascota: ");
        String nombre = scannerDeCadenas.nextLine();
        System.out.println("Ingrese edad de mascota: ");
        int edad = scannerNumerico.nextInt();
        
        Mascota mascota = new Mascota();
        mascota.nombre = nombre;
        mascota.edad = edad;
        
        
        for (int i = 0; i < mascotas.length; i++) {
            if (mascotas[i] == null) {
                mascotas[i] = mascota;
                break;
            }
        }
    }
    
    public static void mostrarMascotasOrdenadas() {
        System.out.println("Las mascotas registradas son:");
        for (int i = 0; i < mascotas.length; i++) {
            for (int j = 0; j < mascotas.length - 1; j++) {
                if (mascotas[j] == null || mascotas[j + 1] == null) {
                    break;
                }
                Mascota mascotaAcutal = mascotas[j];
                Mascota mascotaSiguinte = mascotas[j + 1];
                if (mascotaAcutal.edad > mascotaSiguinte.edad) {
                    mascotas[j] = mascotaSiguinte;
                    mascotas[j + 1] = mascotaAcutal;
                }
            }
        }
        
        for (int i = 0; i < mascotas.length; i++) {
            if (mascotas[i] == null) {
                break;
            }
            System.out.println(mascotas[i].nombre + " - " + mascotas[i].edad);
        }
    }

    public static void main(String[] args) {
        menuPrencipal();
    }
}
