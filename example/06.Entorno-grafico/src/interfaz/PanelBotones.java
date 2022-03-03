package interfaz;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel  {

    private final String VER = "Ver Datos";
    private final String SALIR = "Salir";
    private Ventana interfazEmpleado;
    private JButton botonVer;
    private JButton botonSalir;
    private Eventos eventos;

    public PanelBotones(Ventana interfaz) {
        interfazEmpleado = interfaz;
        this.eventos = new Eventos(this);
        setBorder(new CompoundBorder(new EmptyBorder(0, 0, 5, 0), new TitledBorder("Panel de Botones")));

        setLayout(new FlowLayout());
        botonVer = new JButton("Ver Datos");
        botonVer.setActionCommand(VER);
        botonVer.addActionListener(this.eventos);

        botonSalir = new JButton("Salir");
        botonSalir.setActionCommand(SALIR);
        botonSalir.addActionListener(this.eventos);

        add(botonVer);
        add(botonSalir);
    }
    
    public void mostrarDatos(){
        interfazEmpleado.mostrarDatos();
    }
    public void salir(){
        interfazEmpleado.salir();
    }
}