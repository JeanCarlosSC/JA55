package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.Vista;

/**
 * conmtrolador de MVC Implementa ActionListener para poder escuchar los eventos
 * de la vista
 *
 * @author Jhon
 */
public class Controlador implements ActionListener {

    //se enlaza la bvista y el control para servir de intermediario entre los dos componentes
    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        //le envia la referencia del listener al boton de la vista
        this.vista.btnMultiplicar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnSalir.addActionListener(this);
    }

    public void iniciar() {
        //colocarle un titulo a la ventana
        this.vista.setTitle("Multiplicar numeros");
        //Se le indica la posicion --> null para que la ventana inicie en la posicion 0 es decir en el centro de la pantalla
        this.vista.setLocationRelativeTo(null);
    }

    //funcion que realiza el boton
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnMultiplicar) {
            this.modelo.setNumero1(Integer.parseInt(this.vista.texto1.getText()));
            this.modelo.setNumero2(Integer.parseInt(this.vista.texto2.getText()));
            this.modelo.multiplicar();
            this.vista.textoResultado.setText(String.valueOf(this.modelo.getResultado()));
        }
        if (e.getSource() == this.vista.btnLimpiar) {
            this.vista.blanquearCampos();
        }
        if (e.getSource() == this.vista.btnSalir) {
            this.vista.setVisible(false);
            this.vista.dispose();
        }
    }

}
