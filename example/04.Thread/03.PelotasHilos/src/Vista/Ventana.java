package Vista;

import Control.BolaThread;
import Modelo.Bola;
import javax.swing.*;
import java.awt.*;


public class Ventana extends JFrame { 

    private BolaCanvas canvas; 
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    private JPanel buttonPanel;
    public JButton salir;
    public JButton saludar;
    public JButton adicionarBola;
    private Eventos eventos;

    public Ventana() { 
        setSize(WIDTH, HEIGHT);
        setTitle("Hilos de Pelotas");
        canvas = new BolaCanvas(); 
        add(canvas, BorderLayout.CENTER);
        eventos=new Eventos(this);
        buttonPanel = new JPanel(); 
        
        adicionarBola=new JButton();
        adicionarBola.setText("Adicionar Bola");
        adicionarBola.addActionListener(eventos);
        buttonPanel.add(adicionarBola);
        
        saludar=new JButton();
        saludar.setText("Saludar");
        saludar.addActionListener(eventos);
        buttonPanel.add(saludar);       
        
        
        salir=new JButton();
        salir.setText("Salir");
        salir.addActionListener(eventos);
        buttonPanel.add(salir);       
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show();
    }


   public void addBall() {
        Bola b = new Bola(canvas);
        canvas.add(b);
        BolaThread thread = new BolaThread(b);
        thread.start();
    }
}