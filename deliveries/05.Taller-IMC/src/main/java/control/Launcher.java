package control;

import Vista.Ventana;

/**
 *
 * @author Jean Carlos Santoya Cabrera
 */
public class Launcher {
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        new Controller(ventana);
    }
}
