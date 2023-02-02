/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ipc1.clase1;

import java.util.Scanner;

/**
 *
 * @author josed
 */
public class Clase1 {

    /* 
        Este es el metodo principal, es decir el primer metodo
        a ejecutar cuando se inicie el programa, este se escribe de
        manera automatica 
    */
    public static void main(String[] args) {
        String nombre = "Víctor";
        System.out.println(nombre);
        

        // Variables int: Enteros positivos y negativos
        int entero;
        entero = 100;
        entero = -100;
               
        // Varibales booleandas verdadero y falso
        boolean valor;
        valor = true;
        valor = false;
        
        // Variables double: Decimales positivos y negativos
        double decimal;
        decimal = 100.25;
        decimal = -100.25;
        
        // Varaibles char: Caracteres o valor ASCII
        char caracter;
        caracter = 'A';
        caracter = 65;
        
        // Variables string: Cadenas de texto
        String cadena;
        cadena = "Hola mundo :)";
        
        /*
        Imprimir en consola:
        Para imprimir en consola usamos las instrucciones: 
        > System.out.println(expresion) 
        Imprime el valor de expresion con un salto de linea al final 

        > System.out.print(expresion)
        Imprime el valor de expresion sin un salto de linea al final
        */
        
        // Salida en consola
        System.out.println("Hola estudiantes de IPC1");
        
        // Imprimiendo variabels
        System.out.println(cadena);
        
        // Imprimiendo cadenas + variables
        System.out.println(cadena + " - concatenamos texto");
        System.out.println(cadena + " " + entero);
        System.out.println(decimal + entero);
        // Atajo: Si escriben "sout" + tab escribe automaticamente el println
        
        /*
        Obtener entrada por consola y almecenarla en una variable utilizando
        un scanner
        */
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Bienvenido al laboratorio de IPC1");
        // Para guardar cadenas usamos Scanner.nextLine()
        System.out.print("Ingrese su nombre: ");
        cadena = scanner.nextLine();
        
        // Para guardar enteros usamos Scanner.nextInt()
        System.out.print("Ingrese su edad: ");
        entero = scanner.nextInt();
        scanner.nextLine(); // Limpiar el scanner luego de ingresar valor numerico
        
        // Para guardar decimales usamos Scanner.nextDouble()
        System.out.print("Ingrese su nota de laboratorio: ");
        decimal = scanner.nextDouble();
        scanner.nextLine();
        
        // Mostrando la información almacenada
        /*
            Queremos mostrar la informacion que recolectamos en las variables
            y en el ejemplo se puede ver como el texto va cambiando segun la
            informacion que se va ingresando
        */
        System.out.println("--- RESUMEN DE LOS DATOS ---");
        System.out.println("Nombre: " + cadena);
        System.out.println("Edad: " + entero);
        System.out.println("Nota: " + decimal);
        
        /*
            If y Else if:
            En este caso decimal esta guardando la nota segun el texto anterior
            por lo tanto es el ejemplo perfecto para mostrar como funciona un
            if, if-else, if-else if-else
    
            La sentencia IF y ELSE IF, sirve para evaluar una condicion.
        */
        
        if(decimal > 60)
        {
            //Si la condicion es verdadera, se cumple esta porcion de codigo
            System.out.println("Felicidades " + cadena + " Ganaste laboratorio");
        }
        // Si la condicion anterior es falsa, entonces se va a la segunda condicion
        else if(decimal > 57)
        {
            //Si la condicion es verdadera, se cumple esta porcion de codigo
            System.out.println("Te quedaste por poquitititito");
        }
        // Si la condicion anterior es falsa, se va a la siguiente condicion.
        else{
            // Si entra aqui, significa que ninguna condicion anterior es verdadera
            System.out.println("F, echale ganas :(");
        }
        
        // SENTENCIA SWITCH
        /*
            Esta sentencia se utiliza normalmente cuando hay muchas opciones
            Es decir si las condiciones abarcan igualdad es mas recomendable
            Utilizar un Switch que un If-Else.
    
            El siguiente ejemplo ingresamos un numero del 1 al 7 y el Switch
            verifica la variable para dar un mensaje segun la condicion.
        */
  
        System.out.println("INGRESE UN NUMERO DEL 1 al 7");
        entero = scanner.nextInt();
        scanner.nextLine();
        /* 
            Switch (variable): Esta variable es la que tiene el valor a evaluar
            Se utiliza case y el valor a comparar
            Dentro de cada case debe de terminar con un break.
        
            Se utiliza un default para indicar que ninguna
            de las opciones anteriores es valida, es decir que el valor
            no cumple ninguna de los casos.
        */
        switch(entero){
            case 1:
                System.out.println("ES EL DIA LUNES");
                break;
            case 2:
                System.out.println("ES EL DIA MARTES");
                break;
            case 3:
                System.out.println("ES EL DIA MIERCOLES");
                break;
            case 4:
                System.out.println("ES EL DIA JUEVES");
                break;
            case 5:
                System.out.println("ES EL DIA VIERNES");
                break;
            case 6:
                System.out.println("ES EL DIA SABADO");
                break;
            case 7:
                System.out.println("ES EL DIA DOMINGO");
                break;                
            default:
                System.out.println("NO ES NINGUN DIA DE LA SEMANA");
                break;
        }
    }
}
