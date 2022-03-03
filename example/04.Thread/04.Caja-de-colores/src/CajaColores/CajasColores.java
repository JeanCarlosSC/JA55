package CajaColores;


import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class CajasColores extends JFrame {

    public CajasColores(int pause, int grid) {
        setTitle("Cajas de Colores");
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid * grid; i++) {
            add(new CajaColor(pause));
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(600, 500);
        setVisible(true);
    }
}