package Vista;

import Control.Controlador;
import java.util.Scanner;

public class Interfaz {

    private Scanner lector;

    public Interfaz() {
        lector = new Scanner(System.in);
    }
    
    /**
     * Metodo para capturar los datos de un cliente
     * Recibe la referencia actual del control para llevar a cabo su invocacion
     * @param control 
     */
    public void capturarDatosCliente(Controlador control) {
        int id;
        String nombre;
        String apellido;
        System.out.println("**** Ingrese los Datos del Cliente ****");
        System.out.println("Id: ");
        id = lector.nextInt();
        System.out.println("Nombre: ");
        nombre = lector.next();//lector.nextLine();
        System.out.println("Apellido: ");
        apellido = lector.next();
        control.crearCliente(id, nombre, apellido);
    }

    /**
     * Metodo para mostrar los datos de un cliente
     * Dado que no conoce el modelo, solo recibe los parametros
     * @param id
     * @param nombre
     * @param apellido 
     */
    public void imprimirDatosCliente(int id, String nombre, String apellido) {
        System.out.println("**** DATOS CLIENTE ****");
        System.out.println("Id: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
    }
}
