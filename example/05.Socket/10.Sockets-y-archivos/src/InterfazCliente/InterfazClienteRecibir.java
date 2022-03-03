package InterfazCliente;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.JFrame;
import cliente.ClienteRecibir;

public class InterfazClienteRecibir extends JFrame {
    private static ClienteRecibir cliente;
    private PanelRecibir panel;

    public InterfazClienteRecibir() {
        setLayout(new BorderLayout());
        this.setSize(421, 361);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Cliente TCP - Recibir Datos");
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridBagLayout());
        panel = new PanelRecibir(this);
        GridBagConstraints gbc = new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.SOUTH, new Insets(5, 5, 5, 5), 0, 0);
        add(panel, gbc);
    }

    public void dispose() {
        super.dispose();
        System.exit(0);
    }

    public void Conectar() {
        try {
            cliente.conectarRecibir();
            cliente.recibirPaquetes();
            dispose();
        } catch (IOException e) {
            System.out.println("IClienteRecibir >> Error al conectar el Cliente que recibe");
        }
    }

    public void salir() {
        dispose();
    }

    public static void main(String[] args) {
        try {
            //el properties donde se encuentran las caracteristicas del cliente
            String archivoPropiedades = "D:\\UDistrital\\Gestion Academica\\Pregrado\\Prog Avanzada\\Clase 2021\\Clase 18 D - Sockets y Archivos\\PruebaSocketsV\\src\\data\\cliente2.properties";
            cliente = new ClienteRecibir(archivoPropiedades);
            InterfazClienteRecibir interfaz = new InterfazClienteRecibir();
            interfaz.setVisible(true);
        } catch (Exception e) {
            System.out.println("IClienteRecibir >> Error al crear el Cliente que recibe");
        }
    }
}
