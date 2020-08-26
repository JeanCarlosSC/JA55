package app;

import app.rooms.MainRoom;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Window extends JFrame implements KeyListener{
    Room main;
    
    public Window(){
        addKeyListener(this);
        getContentPane().setBackground(Color.green);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1280,720);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void drawMain(){
        main = new MainRoom();
        getContentPane().removeAll();
        add(main);
        repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
