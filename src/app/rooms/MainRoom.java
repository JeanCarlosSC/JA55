package app.rooms;

import app.master.Objeto;
import app.master.Room;
import app.components.PressEnter;
import java.awt.Color;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class MainRoom extends Room{
    
    public MainRoom(){
        super(0, 0, 1280, 720, "main");
        
        Objeto pressStart = new PressEnter(410, 620);
        
        addComponent(pressStart, -1);
        
        setBackground(Color.BLACK);
    }
    
}
