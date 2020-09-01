package app.rooms;

import app.objects.ObjBackground;
import app.objects.ObjPressEnter;
import services.gameService.GameObject;
import services.gameService.GameRoom;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class MainRoom extends GameRoom{
    
    private GameObject pressStart, background;
    
    public MainRoom(){
        super(0, 0, 1280, 720, "main");
        
        pressStart = new ObjPressEnter(410, 620);
        background = new ObjBackground();
        
        addGameObject(pressStart, "top");
        addGameObject(background, "bottom");
    }
    
}
