package VistaServidor;

import ControlServidor.ServidorHilo;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author sebas
 */
public class VentanaServidor extends JFrame{
    
    private PanelSuperior panelSuperior;
    private PanelTexto panelTexto;
    private PanelInferior panelInferior;
    
    protected ServidorHilo eventos;
    
    public VentanaServidor(ServidorHilo eventos){
        this.eventos = eventos;
        
        setTitle("Chat con el Cliente");
        setSize(400,360);
        setLayout(new BorderLayout());
        
        panelSuperior = new PanelSuperior();
        panelTexto = new PanelTexto();
        panelInferior = new PanelInferior(this);
        
        add(panelSuperior, BorderLayout.NORTH);
        add(panelTexto, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setResizable(false);
        setLocationRelativeTo(null);
        
        setVisible(true);
    }
    
   // método utilitario que es llamado desde otros subprocesos para manipular a
   // areaPantalla en el subproceso despachador de eventos
   public void mostrarMensaje( final String mensajeAMostrar )
   {
      // mostrar mensaje del subproceso de ejecución despachador de eventos
      SwingUtilities.invokeLater(
         new Runnable() {  // clase interna para asegurar que la GUI se actualice apropiadamente

            public void run() // actualiza areaPantalla
            {
               panelTexto.areaPantalla.append( mensajeAMostrar );
               panelTexto.areaPantalla.setCaretPosition(panelTexto.areaPantalla.getText().length() );
            }

         }  // fin de la clase interna

      ); // fin de la llamada a SwingUtilities.invokeLater
   }
   // método utilitario que es llamado desde otros subprocesos para manipular a 
   // campoIntroducir en el subproceso despachador de eventos
   public void establecerCampoTextoEditable( final boolean editable )
   {
      // mostrar mensaje del subproceso de ejecución despachador de eventos
      SwingUtilities.invokeLater(
         new Runnable() {  // clase interna para asegurar que la GUI se actualice apropiadamente

            public void run()  // establece la capacidad de modificar a campoIntroducir
            {
               panelInferior.campoIntroducir.setEditable( editable );
            }

         }  // fin de la clase interna

      ); // fin de la llamada a SwingUtilities.invokeLater
   }
   
   public void limpiarTexto(){
       panelInferior.campoIntroducir.setText("");   
   }
   
    public void errorTextArea(){
        panelTexto.areaPantalla.append("\nError al escribir el objeto");
    }   
    
    public String getCampoTexto(){
        return panelInferior.campoIntroducir.getText();
    }   
    
    public boolean verificarCampo(){
        if ("".equals(panelInferior.campoIntroducir.getText())) {
            return true;
        }

        return false;
    }    
}
