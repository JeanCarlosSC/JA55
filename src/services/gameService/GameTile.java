package services.gameService;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public abstract class GameTile extends JLabel{
    private String title;
    
    public GameTile(int x, int y, String path, int width, int height, String title){
        this.title = title;
        
        ImageIcon iIcono = new ImageIcon(Icon.class.getResource(path));
        Icon icono = new ImageIcon(iIcono.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        
        setSize(icono.getIconWidth(), icono.getIconHeight());
        setLocation(x, y);
        setIcon(icono);
    }
    
    public String getTitle(){
        return title;
    }
    
    
    public abstract GameTile getNewTile(int x, int y);
}
