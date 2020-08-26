package app;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public abstract class Room extends JPanel{
    ArrayList<Objeto> components;
    
    public Room (int x, int y, int width, int height){
        components = new ArrayList<Objeto>();
        
        setLocation(x*-1, y*-1);
        setSize(width, height);
    }
    
    public void addComponent(Objeto objeto){
        components.add(objeto);
        add(components.get(components.size() - 1));
    }
    
    public void update(){
        if(components.size() > 0){
            for(int i=0; i<components.size(); i++){
                components.get(i).update();
            }
        }
    }
}
