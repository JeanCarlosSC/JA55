package services.gameService;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public abstract class GameObject extends JPanel{
    
    private GameSprite sprite;
    
    public GameObject(int x, int y, int width, int height, GameSprite sprite){
        this.sprite = sprite;
        if(sprite != null)
            add(this.sprite);
        
        setLocation(x, y);
        setSize(width, height);
        setLayout(null);
        setBackground(new Color(0, 0, 0, 1));
    }
    
    public void nextIndex(){
        sprite.nextIndex();
    }
    
    public abstract void update();
    
}
