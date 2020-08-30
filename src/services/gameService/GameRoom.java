package services.gameService;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public abstract class GameRoom extends JPanel{
    
    private ArrayList<GameObject> objects;
    private String title;
    
    public GameRoom (int x, int y, int width, int height, String title){
        objects = new ArrayList<GameObject>();
        
        this.title = title;
        
        setLocation(x*-1, y*-1);
        setSize(width, height);
        setLayout(null);
    }
    
    public void addGameObject(GameObject object, int height){
        objects.add(object);
        add(objects.get(objects.size() - 1), height);
    }
    
    public void addGameObject(GameObject object){
        objects.add(object);
        add(objects.get(objects.size() - 1));
    }
    
    public void addTiles(int x, int y, int filas, int columnas, GameTile tile){
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                //Problem
                //add(new Class<tile.getClass()>(x+j*64,y+i*64));
            }
        }
    }
    
    public void run(){
        if(objects.size() > 0){
            for(int i=0; i<objects.size(); i++){
                objects.get(i).run();
            }
        }
        repaint();
    }
    
    public String getTitle(){
        return title;
    }
}