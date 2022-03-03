package InterfazCliente;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import javax.swing.JFrame;
import cliente.ClienteEnviar;

public class InterfazClienteEnviar extends JFrame {

    private static ClienteEnviar cliente;
    private PanelEnviar panel;

    public InterfazClienteEnviar() throws Exception {
        setLayout(new BorderLayout());
        this.setSize(367, 292);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Cliente TCP - Enviar Datos");
        setLocationRelativeTo(null);
        getContentPane().setLayout(new GridBagLayout());
        panel = new PanelEnviar(this);
        GridBagConstraints gbc = new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.SOUTH, new Insets(5, 5, 5, 5), 0, 0);
        add(panel, gbc);
    }

    public void dispose() {
        super.dispose();
        System.exit(0);
    }

    public void enviar() {
        try {
            cliente.conectar();
            cliente.enviarPaquetes();
            dispose();
        } catch (IOException e) {
            System.out.println("IClienteEnviar >> Error de Conexion ClienteE --> Servidor");
        }
    }

    public void salir() {
        dispose();
    }

    public static void main(String[] args) {
        try {
            //el properties donde se encuentran las caracteristicas del cliente
            String archivoPropiedades = "D:\\UDistrital\\Gestion Academica\\Pregrado\\Prog Avanzada\\Clase 2021\\Clase 18 D - Sockets y Archivos\\PruebaSocketsV\\src\\data\\cliente1.properties";
            cliente = new ClienteEnviar(archivoPropiedades);
            InterfazClienteEnviar interfaz = new InterfazClienteEnviar();
            interfaz.setVisible(true);
        } catch (Exception ex) {
            System.out.println("IClienteEnviar >> Error al crear el Cliente que envia");
        }
    }
}
