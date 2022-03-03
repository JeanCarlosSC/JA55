package VistaCliente;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sebas
 */
public class PanelSuperior extends JPanel{
    
    private JLabel imagenServidor;

    
    public PanelSuperior(){
        
        GridBagLayout gridbag = new GridBagLayout();
        setLayout(gridbag);
        GridBagConstraints gbc;  
        
        
        imagenServidor = new JLabel("Servidor");
        gbc = new GridBagConstraints(0, 0, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
        setBackground(Color.white);
        ImageIcon imgIcon = new ImageIcon("src/Imagenes/servidor.png");
        Image imgEscalada = imgIcon.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        imagenServidor.setIcon(iconoEscalado);  
        add(imagenServidor, gbc);
       
    }
}
