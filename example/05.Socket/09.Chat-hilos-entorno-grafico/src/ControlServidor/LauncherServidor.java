package ControlServidor;

/**
 *
 * @author sebas
 */
public class LauncherServidor {


    public static void main(String[] args) {
        String puerto = "12345";
        Servidor servidor = new Servidor(Integer.parseInt(puerto));
        servidor.iniciarServidor();
    }

}
