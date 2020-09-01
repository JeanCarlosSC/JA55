package services.gameService;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public abstract class GameSprite extends JLabel{
    
    private ArrayList<Integer> index;//the index is positive
    private int currentIndex;
    
    private GameSprite(int x, int y, Icon icono){
        index = new ArrayList<Integer>();
        
        addIndex(x, y);
        setIndex(0);
        
        setBackground(null);
        setIcon(icono);
        setSize(icono.getIconWidth(), icono.getIconHeight());
    }
    
    public GameSprite(int x, int y, String path){
        this(x, y, new ImageIcon(Icon.class.getResource(path)));
    }
    
    public GameSprite(int x, int y, int width, int height, String path){
        this(x, y, new ImageIcon((new ImageIcon(Icon.class.getResource(path))).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    }
    
    public GameSprite(int x, int y, int scale, String path){
        this(x, y, (new ImageIcon(Icon.class.getResource(path))).getIconWidth()*scale,
                (new ImageIcon(Icon.class.getResource(path))).getIconHeight()*scale, path);
    }
    
    public void nextIndex(){
        if(currentIndex < index.size() / 2 && index.size() / 2 > 1)
            setIndex(currentIndex + 1);
        else
            setIndex(0);
    }
    
    public void setIndex(int index){
        currentIndex = index;
        if(index!=0){
            index *= 2;
            setLocation(this.index.get(index-1) * -1, this.index.get(index) * -1);
        }else
            setLocation(this.index.get(0), this.index.get(1));
    }
    
    public void addIndex(int x, int y){
        index.add(x);
        index.add(y);
    }
}
