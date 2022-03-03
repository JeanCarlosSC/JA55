package InterfazCliente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelRecibir extends JPanel implements ActionListener {

    private static final String OPCION_1 = "Enviar";
    private static final String OPCION_2 = "Recibir";
    private InterfazClienteRecibir ppal;
    private JButton btnOpcion1;
    private JButton btnOpcion2;

    public PanelRecibir(InterfazClienteRecibir interfazCliente) {
        ppal = interfazCliente;

        setBorder(new TitledBorder("Opciones"));
        setLayout(new GridBagLayout());
        this.setPreferredSize(new java.awt.Dimension(204, 140));
        btnOpcion1 = new JButton("Recibir");
        btnOpcion1.setActionCommand(OPCION_1);
        btnOpcion1.addActionListener(this);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(btnOpcion1, gbc);
        btnOpcion2 = new JButton("Salir");
        btnOpcion2.setActionCommand(OPCION_2);
        btnOpcion2.addActionListener(this);
        gbc.gridx = 1;
        add(btnOpcion2, gbc);
    }

    public void actionPerformed(ActionEvent e) {
        if (OPCION_1.equals(e.getActionCommand())) {
            ppal.Conectar();
        } else if (OPCION_2.equals(e.getActionCommand())) {
            ppal.salir();
        }
    }
}