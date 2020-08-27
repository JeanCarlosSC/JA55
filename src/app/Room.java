package app;

import app.tiles.Floor;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public abstract class Room extends JPanel{
    private ArrayList<Objeto> components;
    private String title;
    
    public Room (int x, int y, int width, int height, String title){
        components = new ArrayList<Objeto>();
        this.title = title;
        
        setLocation(x*-1, y*-1);
        setSize(width, height);
    }
    
    public void addComponent(Objeto objeto, int height){
        components.add(objeto);
        add(components.get(components.size() - 1), height);
    }
    
    public void addTiles(int x, int y, int filas, int columnas, String tileName){
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                switch(tileName){
                    case "lawn":
                        add(new Floor(x+j*64,y+i*64));
                        break;
                    case "floor":
                        add(new Floor(x+j*32,y+i*32));
                        break;
                }
            }
        }
    }
    
    public void update(){
        if(components.size() > 0){
            for(int i=0; i<components.size(); i++){
                components.get(i).update();
            }
        }
    }
    
    public String getTitle(){
        return title;
    }
    
}
