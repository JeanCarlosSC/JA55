package app.objects;

import app.sprites.SpBackground;
import services.gameService.GameObject;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class ObjBackground extends GameObject{
    
    public ObjBackground(){
        super(0, 0, 1280, 720, new SpBackground());
    }

}
