package services.gameService;

import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public abstract class GameObject extends JPanel{
    
    private GameSprite sprite;
    
    public GameObject(int x, int y, GameSprite sprite){
        this.sprite = sprite;
        
        setLocation(x, y);
        setLayout(null);
        setBackground(null);
    }
    
    public void nextIndex(){
        sprite.nextIndex();
    }
    
    public abstract void update();
    
}
