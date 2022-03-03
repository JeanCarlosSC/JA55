package InterfazCliente;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelEnviar extends JPanel implements ActionListener {

    private static final String OPCION_1 = "Enviar";
    private static final String OPCION_2 = "Recibir";
    private InterfazClienteEnviar ppal;
    private JButton btnOpcion1;
    private JButton btnOpcion2;

    public PanelEnviar(InterfazClienteEnviar interfazCliente) {
        ppal = interfazCliente;
        setBorder(new TitledBorder("Opciones del Cliente"));
        setLayout(new GridBagLayout());
        this.setPreferredSize(new java.awt.Dimension(220, 114));
        btnOpcion1 = new JButton("Enviar");
        btnOpcion1.setActionCommand(OPCION_1);
        btnOpcion1.addActionListener(this);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(btnOpcion1, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));

        btnOpcion2 = new JButton("Salir");
        btnOpcion2.setActionCommand(OPCION_2);
        btnOpcion2.addActionListener(this);
        gbc.gridx = 1;
        this.add(btnOpcion2, new GridBagConstraints(1, 0, 2, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 5), 0, 0));
    }

    public void actionPerformed(ActionEvent e) {
        if (OPCION_1.equals(e.getActionCommand())) {
            ppal.enviar();
        } else if (OPCION_2.equals(e.getActionCommand())) {
            ppal.salir();
        }
    }
}