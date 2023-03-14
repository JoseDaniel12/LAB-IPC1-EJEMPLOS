/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ipc1.clase7;

/**
 *
 * @author josed
 */
public class Clase7 {

    public static void main(String[] args) {
        Usuario u = new Usuario("jose", "1234", "12/12/2000", "Masculino");
        AppState.usuarios.add(u);
        
        LoginFrame loginFrame = new LoginFrame();
    }
}
