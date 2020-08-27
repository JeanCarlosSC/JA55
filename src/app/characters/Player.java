package app.characters;

import app.master.Character;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Player extends Character{
    
    public Player(int x, int y){
        super(x, y, 32, 64, "/resources/character/skeleton.png", 22, 22);
    }
    
}
