package app.objects;

import services.gameService.GameObject;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class ObjPlayer extends GameObject{
    
    public ObjPlayer(int x, int y){
        super(x, y, 64, 64, null);
    }

    @Override
    public void run() {
    }
    
}
