package app.sprites;

import services.gameService.GameSprite;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class SpBackground extends GameSprite{
    
    public SpBackground(){
        super(0, 0, 2, "/resources/images/main.png");
    }
    
    @Override
    public void nextIndex(){
        if(getLocation().x < -703)
            setLocation(0, getLocation().y);
        else
            setLocation(getLocation().x-16, getLocation().y);
    }
    
}
