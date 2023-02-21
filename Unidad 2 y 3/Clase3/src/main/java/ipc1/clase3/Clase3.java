package ipc1.clase3;

/**
 *
 * @author josed
 */


public class Clase3 {
    
    public static int sumar(int n1, int n2) {
        System.out.println("voy a hacer una suma");
        int resultado = n1 + n2;
        return resultado;
    }
    

    public static void main(String[] args) {

        int res = sumar(1,2);
        int num = 1+2;
        System.out.println(res);
    }
}
