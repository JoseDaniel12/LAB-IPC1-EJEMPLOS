package ipc1.borradorclase11;

import handlers.JPEGHandler;
import estructuras.ListaSimple;
import handlers.JPEGImageHandlerBN;
/**
 *
 * @author josed
 */
public class BorradorClase11 {
    
    public static void convertirBlancoNegro(String rutaImagen) {
        JPEGImageHandlerBN handlerBn = new JPEGImageHandlerBN(rutaImagen);
        try {
            JPEGHandler.runHandler(handlerBn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        convertirBlancoNegro("./nintendo.jpg");
        
        Usuario jose = new Usuario("Jose");
        Usuario daniel = new Usuario("daniel");
        ListaSimple listaSimple = new ListaSimple();
        listaSimple.add(jose);
        listaSimple.add(daniel);
        System.out.println(listaSimple.getSize());
        System.out.println(((Usuario)listaSimple.get(0)).nombre);
        System.out.println(((Usuario)listaSimple.get(1)).nombre);
    }
}
