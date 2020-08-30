package app.objects;

import app.sprites.SpPressEnter;
import javax.swing.JLabel;
import services.graphicService.GraphicBuilder;
import services.gameService.GameObject;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class ObjPressEnter extends GameObject{
    private GraphicBuilder gs;
    
    private JLabel lPressEnter;
    
    public ObjPressEnter(int x, int y){
        super(x, y, 398, 52, new SpPressEnter());
    }

}
