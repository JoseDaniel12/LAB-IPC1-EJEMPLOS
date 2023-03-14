package ipc1.clase7;

import java.util.LinkedList;

/**
 *
 * @author josed
 */
public class AppState {
    public static Usuario usuarioLogeado;
    public static LinkedList<Usuario> usuarios = new LinkedList<>();
    LoginFrame loginFrame = new LoginFrame();
}
