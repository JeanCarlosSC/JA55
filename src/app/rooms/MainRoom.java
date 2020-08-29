package app.rooms;

import app.components.PressEnter;
import java.awt.Color;
import services.gameService.GameObject;
import services.gameService.GameRoom;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class MainRoom extends GameRoom{
    
    public MainRoom(){
        super(0, 0, 1280, 720, "main");
        
        GameObject pressStart = new PressEnter(410, 620);
        
        addGameObject(pressStart, -1);
        
        setBackground(Color.BLACK);
    }
    
}
