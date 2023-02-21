package ipc1.clase4;

import ipc1.vehiculos.Avion;
import ipc1.vehiculos.Carro;




/**
 *
 * @author josed
 */

public class Clase4 {
    
    public static void main(String[] args) {
        Carro carro = new Carro(4);
        System.out.println("ruedas:");
        for (int i = 0; i < carro.ruedas.size(); i++) {
            System.out.println(carro.ruedas.get(i).radio);
        }
    }
}
