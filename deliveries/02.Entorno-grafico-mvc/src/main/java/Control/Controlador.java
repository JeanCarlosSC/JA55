/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Modelo.Cliente;
import Vista.Ventana;
import java.util.ArrayList;

public class Controlador {
    private Ventana vista;
    public  ArrayList<Cliente> listaClientes =new ArrayList<Cliente>();
    
    public Controlador(Ventana vista){
        this.vista = vista;
    }
    
    public boolean insertarCliente(int id, String nombre, String apellido) {
        if(existeCliente(id)) {
            return false; //no se pudo insertar
        }
        
        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setId(id);
        cliente.setApellido(apellido);
        listaClientes.add(cliente);
        return true;
    }
    
    public boolean existeCliente(int id) {
        for(Cliente cliente : listaClientes) {
            if (cliente.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    public String getNombre(int id) {
        for(Cliente cliente : listaClientes) {
            if(cliente.getId() == id) {
                return cliente.getNombre();
            }
        }
        return "";
    }
    
    public String getApellido(int id) {
        for(Cliente cliente : listaClientes) {
            if(cliente.getId() == id) {
                return cliente.getApellido();
            }
        }
        return "";
    }
    
/*
    public void crearCliente(int id,String nombre, String apellido){
     Cliente modelo=new Cliente();
     modelo.setId(id);
     modelo.setNombre(nombre);
     modelo.setApellido(apellido);
     listaClientes.add(modelo);
     actualizarVista(modelo);
    }

    public void actualizarVista(Cliente modelo){
        vista.ImprimirDatosCliente(modelo.getId(),modelo.getNombre(),modelo.getApellido());
        vista.menu(this);
    }
    
    public void ImprimirClientes(Controlador control){
        System.out.println("***CLIENTES AÑADIDOS***");
        System.out.println("ID------cliente");
        for(int i=0; i <listaClientes.size();i++){
            System.out.println(listaClientes.get(i).getApellido()+listaClientes.get(i).getId());
        }
    }
*/
}
