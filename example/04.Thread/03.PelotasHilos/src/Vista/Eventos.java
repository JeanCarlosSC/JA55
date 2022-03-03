package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class Eventos implements ActionListener {

    private Ventana ventana;

    public Eventos(Ventana ven) {
        this.ventana = ven;
        this.ventana.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.ventana.salir) {
            System.exit(0);
        }
        if (e.getSource() == this.ventana.adicionarBola) {
            this.ventana.addBall();
        }
        if (e.getSource() == this.ventana.saludar) {
            JOptionPane.showMessageDialog(null, "Este  es un programa de bolas con hilos");
        }
    }
}
