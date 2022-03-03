package ControlCliente;

/**
 *
 * @author sebas
 */
public class LauncherCliente {


    public static void main(String[] args) {
        Cliente aplicacion = new Cliente("127.0.0.1");
        aplicacion.ejecutarCliente();
    }

}
