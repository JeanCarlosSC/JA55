package Control;

import Modelo.Cliente;
import Vista.Interfaz;

public class Controlador {

    //objetos vista y modelo
    private Interfaz vista;
    private Cliente modelo;

    //constructor para inicializar la vista
    //El modelo no se inicializa dado que depende de la accion seleccionada en la vista
    public Controlador(Interfaz vista) {
        this.vista = vista;
        this.vista.capturarDatosCliente(this);
    }

    //Recibe los datos de la vista para crear el modelo
    public void crearCliente(int id, String nombre, String apellido) {
        modelo = new Cliente();
        modelo.setId(id);
        modelo.setNombre(nombre);
        modelo.setApellido(apellido);
        actualizarVista();
    }

    //pasa el modelo a la vista para presentar los datos
    public void actualizarVista() {
        vista.imprimirDatosCliente(modelo.getId(), modelo.getNombre(), modelo.getApellido());
    }
}
