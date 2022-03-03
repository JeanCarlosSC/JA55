package interfaz;

import Control.Controlador;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame {

    private PanelDatos panelDatos;
    private PanelBotones panelExtensiones;
    private Controlador control;

    public Ventana(Controlador con) {
        this.control = con;
        setTitle("Datos del Empleado");
        panelDatos = new PanelDatos(this);
        panelExtensiones = new PanelBotones(this);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelDatos, BorderLayout.NORTH);
        getContentPane().add(panelExtensiones, BorderLayout.SOUTH);

        setSize(430, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actualizarEmpleado(String nombre, String apellido, int sex) {
        String sexo;
        if (sex == 1) {
            sexo = "Masculino";
        } else {
            sexo = "Femenino";
        }
        panelDatos.actualizarCampos(nombre, apellido, sexo);
        validate();
    }

    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null, "Los datos son: \n Nombre:" + panelDatos.getNombre() + " \n Apellido: " + panelDatos.getApellido() + " \n Sexo: " + panelDatos.getSexo());
    }

    public void salir() {
        System.exit(0);
    }
}