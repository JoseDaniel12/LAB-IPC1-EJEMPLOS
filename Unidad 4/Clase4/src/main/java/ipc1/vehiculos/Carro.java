package ipc1.vehiculos;

import java.util.LinkedList;

/**
 *
 * @author josed
 */

public class Carro extends Vehiculo {
    public LinkedList<Rueda> ruedas = new LinkedList();
    
    public Carro(int numRuedas) {
        for (int i = 0; i < numRuedas; i++) {
            this.ruedas.add(new Rueda(4));
        }
    }
    
    @Override
    public void arrancar() {
        System.out.println("Soy un Carro arrancando.");
    }
    
}