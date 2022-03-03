package VistaCliente;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author sebas
 */
public class PanelTexto extends JPanel{
 
    protected JTextArea areaPantalla;
    
    public PanelTexto(){
        
        setBackground(Color.white);        
        areaPantalla = new JTextArea(15,34);
        
        add( new JScrollPane( areaPantalla ));          
       
    }
}
