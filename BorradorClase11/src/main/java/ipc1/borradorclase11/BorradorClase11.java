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
        
        ListaSimple listaSimple = new ListaSimple();
        Usuario jose = new Usuario("Jose");
        Usuario daniel = new Usuario("daniel");
        Usuario alvarado = new Usuario("alvarado");
        listaSimple.add(jose);
        listaSimple.add(daniel);
        listaSimple.add(alvarado);
        listaSimple.listarNombres();
        listaSimple.delete("daniel");
        listaSimple.listarNombres();
        System.out.println("Size: " + listaSimple.getSize());
    }
}
