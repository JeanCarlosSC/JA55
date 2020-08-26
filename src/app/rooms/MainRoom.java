package app.rooms;

import app.Objeto;
import app.Room;
import app.components.PressEnter;
import java.awt.Color;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class MainRoom extends Room{
    
    public MainRoom(){
        super(0, 0, 1280, 720);
        
        Objeto pressStart = new PressEnter(410, 620);
        
        addComponent(pressStart);
        
        setBackground(Color.BLACK);
    }
    
}
