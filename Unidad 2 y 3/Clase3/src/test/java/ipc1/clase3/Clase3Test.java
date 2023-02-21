package ipc1.clase3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 *
 * @author josed
 */
public class Clase3Test {
    
    public Clase3Test() {
    }
    
    @Test
    public void testProbadoUnoMasDos() {
        int resultado = Clase3.sumar(1, 2);
        Assertions.assertEquals(3, resultado);
    }
    
    @Test
    public void testProbadoTresMasDos() {
        int resultado = Clase3.sumar(3, 2);
        Assertions.assertEquals(5, resultado);
    }
}
