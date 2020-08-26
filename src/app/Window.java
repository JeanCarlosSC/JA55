package app;

import app.rooms.MainRoom;
import app.rooms.PsychedelicForest;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Window extends JFrame implements KeyListener{
    Room main, psychedelicForest;
    String roomActual;
    
    public Window(){
        addKeyListener(this);
        getContentPane().setBackground(Color.BLACK);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1280,720);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void drawMain(){
        main = new MainRoom();
        setRoom(main);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER && getRoom().equals("main")){
            if(psychedelicForest == null)
                psychedelicForest = new PsychedelicForest(0, 0);
            setRoom(psychedelicForest);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void setRoom(Room room) {
        roomActual = room.getTitle();
        getContentPane().removeAll();
        add(room);
        repaint();
    }
    
    private String getRoom(){
        if(roomActual != null)
            return roomActual;
        else
            return "null";
    }
    
}
