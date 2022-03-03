package VistaServidor;

import VistaCliente.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sebas
 */
public class PanelInferior extends JPanel{
    
    protected JTextField campoIntroducir;
    private JButton botonEnviar;
    
    private VentanaServidor ventana;
    
    public PanelInferior(VentanaServidor ventana){
        setBackground(Color.white);
        
        this.ventana = ventana;
        
        campoIntroducir = new JTextField(31);
        campoIntroducir.setActionCommand("EnviarEnter");
        campoIntroducir.addActionListener(this.ventana.eventos);
        
        botonEnviar = new JButton();
        botonEnviar.setActionCommand("Enviar");
        botonEnviar.addActionListener(this.ventana.eventos);
        
        ImageIcon imgIcon = new ImageIcon("src/Imagenes/enviar.png");
        Image imgEscalada = imgIcon.getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        botonEnviar.setIcon(iconoEscalado);
        botonEnviar.setPreferredSize(new Dimension(20,20));
        botonEnviar.setBackground(Color.white);
        botonEnviar.setForeground(Color.white);
        
        add(campoIntroducir);
        add(botonEnviar);
    }
}
