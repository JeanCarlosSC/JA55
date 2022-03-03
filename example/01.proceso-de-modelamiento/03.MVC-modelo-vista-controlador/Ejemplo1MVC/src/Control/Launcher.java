package Control;

import Vista.Interfaz;

public class Launcher {

    public static void main(String[] args) {
        Interfaz vista = new Interfaz();
        //se crea un objeto controlador y se le pasa  la vista
        Controlador controlador = new Controlador(vista);

    }
   
}
