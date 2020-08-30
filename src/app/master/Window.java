package app.master;

import app.Main;
import app.rooms.MainRoom;
import app.rooms.PsychedelicForest;
import java.awt.Color;
import javax.swing.JFrame;
import services.gameService.GameRoom;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Window extends JFrame{
    
    private Main main;//ref
    
    private GameRoom currentRoom, mainRoom, psychedelicForest;
    
    public Window(Main main){
        this.main = main;
        
        getContentPane().setBackground(Color.BLACK);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1280,720);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setRoom(GameRoom room) {
        currentRoom = room;
        getContentPane().removeAll();
        add(room);
        repaint();
    }
    
    public void setRoom(String name) {
        switch(name){
            case "main":
                if(mainRoom == null)
                    mainRoom = new MainRoom();
                setRoom(mainRoom);
                break;
            case "psychedelicForest":
                if(psychedelicForest == null)
                    psychedelicForest = new PsychedelicForest(0, 0);
                setRoom(psychedelicForest);
                break;
        }
    }
    
    public String getTitleCurrentRoom(){
        if(currentRoom != null)
            return currentRoom.getTitle();
        return "null";
    }
    
    public void run(){
        currentRoom.run();
    }

}