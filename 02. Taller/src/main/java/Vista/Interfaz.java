/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import Control.Controlador;
import java.util.Scanner;
/**
 *
 * @author curlf
 */
public class Interfaz {
    private Scanner lector;
    
    public Interfaz(){
        lector=new Scanner(System.in);
    }
    /*
    public void menu(Controlador control){
        int n;
        System.out.println("****Alo buenas, ingrese el numero correspondiente a su solicitud :3 ****");
        System.out.println("1 si quiere ingresar un Cliente");
        System.out.println("2 si quiere mostrar los clientes existentes");
        System.out.println("3 si quiere buscar un cliente");
        n=lector.nextInt();
        switch(n){
            case 1:
                capturarDatosCliente(control); 
                break;
            case 2:
                control.ImprimirClientes(control);
                break;
        
        }
        
             
    }
    public void capturarDatosCliente(Controlador control){
        int id;
        String nombre;
        String apellido;
        System.out.println("****Ingrese los Datos del Cliente****");
        System.out.println("id: ");
        id= lector.nextInt();
        System.out.println("Nombre: ");
        nombre =lector.next();
        System.out.println("Apellido: ");
        apellido=lector.next();
        control.crearCliente(id, nombre, apellido);
        
    }
    */
    public void ImprimirDatosCliente(int id, String nombre,String apellido){
        System.out.println("***DATOS CLIENTE***");
        System.out.println("ID: "+ id);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Apellido: "+ apellido);
        
    }
    
    
}
