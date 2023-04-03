package ipc1.clase10;

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
    
    public static void serilizar() {
        File file = new File(rutaUsuariosSerializados);
        
        // Con esto nos aseguramos que la carpeta donde creemos el archiov existe
        if (!file.exists()) {
            file.getParentFile().mkdir();
        }
        
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("No se pudo crear el arcivo de serializacion.");
        }
        
        
        try {
            FileOutputStream fos  = new FileOutputStream(rutaUsuariosSerializados);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(usuarios);
        } catch (FileNotFoundException ex) {
            System.out.println("No encontro la carpeta del archivo.");
        } catch (IOException ex) {
            Logger.getLogger(AppState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void deserializar() {
        try {
            File file = new File(rutaUsuariosSerializados);
            if (!file.exists()) {
                return;
            }
            FileInputStream fis = new FileInputStream(rutaUsuariosSerializados);
            ObjectInputStream ois = new ObjectInputStream(fis);
            usuarios = (LinkedList<Usuario>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AppState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppState.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppState.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
 