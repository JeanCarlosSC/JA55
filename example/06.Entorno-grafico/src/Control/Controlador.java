package Control;

import interfaz.Ventana;
import mundo.Empleado;

public class Controlador {
    private Empleado e;
    private Ventana ventana;

    public Controlador() {
        e = new Empleado();
        e.inicializar("Carlos", "Martinez", 1);
        ventana = new Ventana(this);
        ventana.actualizarEmpleado(e.darNombre(),e.darApellido(),e.darSexo());
    }
}