package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos implements ActionListener {

   private PanelBotones ventana;

    public Eventos(PanelBotones ven) {
        this.ventana = ven;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();
        if (comando.equals("Ver Datos")) {
             this.ventana.mostrarDatos();
        } else if (comando.equals("Salir")) {
            this.ventana.salir();
        }
    }
}
