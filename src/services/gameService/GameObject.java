package services.gameService;

import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public abstract class GameObject extends JPanel{
    
    public GameObject(int x, int y){
        setLocation(x, y);
        setLayout(null);
        setBackground(null);
    }
    
    public abstract void update();
    
}
