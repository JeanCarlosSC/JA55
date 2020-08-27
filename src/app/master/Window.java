package app.master;

import app.Main;
import app.characters.Player;
import app.master.Room;
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
public class Window extends JFrame{
    private Room now, main, psychedelicForest;
    private String roomActual;
    
    public Window(Main main){
        addKeyListener(main);
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
    
    public void addPlayer(Player player){
        now.addPlayer(player);
    }
    
    private void setRoom(Room room) {
        now = room;
        roomActual = room.getTitle();
        getContentPane().removeAll();
        add(room);
        repaint();
    }
    
    public void setRoom(String name) {
        if(name.equals("psychedelicForest")){
            if(psychedelicForest == null)
                psychedelicForest = new PsychedelicForest(0, 0);
            setRoom(psychedelicForest);
        }
    }
    
    public String getRoom(){
        if(roomActual != null)
            return roomActual;
        else
            return "null";
    }

}
