package app.master;

import javax.swing.JLabel;
import services.graphicService.GraphicBuilder;


/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Tile extends JLabel{
    private String title;
    
    public Tile(int x, int y, String path, int width, int height, String title){
        this.title = title;
        
        GraphicBuilder gs = GraphicBuilder.getService();
        
        gs.setLabel(this, gs.getIcon(path, width, height), x, y);
    }
    
    public String getTitle(){
        return title;
    }
    
}
