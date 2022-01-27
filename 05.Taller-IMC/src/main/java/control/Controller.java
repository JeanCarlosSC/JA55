package control;

import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Calculator;
import model.Persona;

public class Controller implements ActionListener{
    private Ventana ventana;    
    private ArrayList<Persona> datos;
    
    public Controller(Ventana ventana) {
        this.ventana = ventana;
        datos = new ArrayList();
        
        //ActionListener
        this.ventana.getBtNuevoCalculo().addActionListener(this);
        this.ventana.getBtCalcular().addActionListener(this);
        this.ventana.getBtGuardar().addActionListener(this);
        this.ventana.getBtSalir().addActionListener(this);
    }
    
    private void nuevoCalculo() {
        ventana.getBtNuevoCalculo().setEnabled(false);
        ventana.getBtCalcular().setEnabled(true);
        ventana.getTfAltura().setEnabled(true);
        ventana.getTfApellido().setEnabled(true);
        ventana.getTfCedula().setEnabled(true);
        ventana.getTfNombre().setEnabled(true);
        ventana.getTfPeso().setEnabled(true);
        ventana.getBtGuardar().setEnabled(false);
        
        ventana.getTfAltura().setText("");
        ventana.getTfApellido().setText("");
        ventana.getTfCedula().setText("");
        ventana.getTfNombre().setText("");
        ventana.getTfPeso().setText("");
        ventana.getTfIMC().setText("");
    }
    
    private void calcular() {
        //Valida espacio vacío
        if(ventana.getTfAltura().getText() == "" || ventana.getTfPeso().getText() == "") {
            JOptionPane.showMessageDialog(ventana, "Inserte la altura y el peso", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //Calcular
        double peso = Double.parseDouble(ventana.getTfPeso().getText());
        double altura = Double.parseDouble(ventana.getTfAltura().getText());
        double imc = Calculator.indiceDeMasaCorporal(peso, altura);
        
        //Mensaje del imc
        JOptionPane.showMessageDialog(ventana, "El estado de esta persona es "+ Calculator.getClasification(imc) + ".");
        
        //Actualiza interfaz
        ventana.getBtCalcular().setEnabled(false);
        ventana.getBtNuevoCalculo().setEnabled(true);
        ventana.getBtGuardar().setEnabled(true);
        
        ventana.getBtCalcular().setEnabled(false);
        ventana.getTfAltura().setEnabled(false);
        ventana.getTfApellido().setEnabled(false);
        ventana.getTfCedula().setEnabled(false);
        ventana.getTfNombre().setEnabled(false);
        ventana.getTfPeso().setEnabled(false);
        ventana.getTfIMC().setText("" + imc);
    }
    
    private void guardar() {
        String nombre = ventana.getTfNombre().getText();
        String apellido = ventana.getTfApellido().getText();
        
        int cedula = Integer.parseInt(ventana.getTfCedula().getText());
        double imc = Double.parseDouble(ventana.getTfIMC().getText());
        double altura = Double.parseDouble(ventana.getTfAltura().getText());
        double peso = Double.parseDouble(ventana.getTfPeso().getText());
        
        Persona persona = new Persona(cedula, nombre, apellido, imc);
        datos.add(persona);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventana.getBtNuevoCalculo()) {
            nuevoCalculo();
        }
        if(e.getSource() == ventana.getBtCalcular()) {
            calcular();
        }
        if(e.getSource() == ventana.getBtGuardar()) {
            guardar();
        }
        if(e.getSource() == ventana.getBtSalir()) {
            String mensaje = "";
            for(int i=0; i<datos.size(); i++) {
                mensaje += datos.get(i).getNombre() + " " + datos.get(i).getApellido() + " C.C: " + datos.get(i).getCedula() +
                        " IMC: " + datos.get(i).getImc() + "\n";
            }
            JOptionPane.showMessageDialog(null, mensaje, "Datos almacenados", JOptionPane.INFORMATION_MESSAGE);
            int answer = JOptionPane.showOptionDialog(ventana, "Seguro que desea salir?", "Salir", 1, JOptionPane.YES_NO_OPTION, null, null, null);
            if (answer == 0) {
                System.exit(0);
            }
        }
    }
}
