package services.gameService;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public abstract class GameRoom extends JPanel{
    
    private ArrayList<GameObject> objects;
    private String title;
    private JPanel top, bottom;
    
    public GameRoom (int x, int y, int width, int height, String title){
        objects = new ArrayList<GameObject>();
        
        this.title = title;
        
        setLocation(x*-1, y*-1);
        setSize(width, height);
        setBackground(Color.BLACK);
        setLayout(null);
        
        bottom = new JPanel();
        bottom.setSize(width, height);
        bottom.setLocation(0, 0);
        bottom.setBackground(Color.RED);
        bottom.setLayout(null);
        add(bottom);
        
        top = new JPanel();
        top.setSize(width, height);
        top.setLocation(0, 0);
        top.setBackground(Color.CYAN);
        top.setLayout(null);
        bottom.add(top);
        
    }
    
    public void addGameObject(GameObject object, String height){
        objects.add(object);
        
        switch(height){
            case "top":
                top.add(object);
                break;
            case "bottom":
                add(object);
                break;
        }
    }
    
    public void addTiles(int x, int y, int filas, int columnas, GameTile tile){
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                add(tile.getNewTile(x+j*tile.getWidth(),y+i*tile.getHeight()));
            }
        }
    }
    
    public void run(){//this method runs 60 times per second
        if(objects.size() > 0){
            for(int i=0; i<objects.size(); i++){
                objects.get(i).run();//moves my JLabels with setLocation
            }
        }
        repaint();
    }
    
    public String getTitle(){
        return title;
    }
}