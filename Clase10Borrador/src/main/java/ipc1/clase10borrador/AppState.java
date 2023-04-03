package ipc1.clase10borrador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josed
 */
public class AppState {
    public static String rutaUsuariosSerializados = "./appState.bin";
    public static LinkedList<Usuario> usuarios = new LinkedList<>();
    
    public static void serializar() {
        File file = new File(rutaUsuariosSerializados);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        
        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(AppFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        
        try {
            FileOutputStream fos = new FileOutputStream(rutaUsuariosSerializados);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(usuarios);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void deserializar() {
        try {
            FileInputStream fis = new FileInputStream(rutaUsuariosSerializados);
            ObjectInputStream ois = new ObjectInputStream(fis);
            usuarios = (LinkedList<Usuario>) ois.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(AppState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}