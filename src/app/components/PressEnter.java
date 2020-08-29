package app.components;

import app.master.Objeto;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import services.graphicService.GraphicBuilder;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class PressEnter extends Objeto{
    private GraphicBuilder gs;
    
    private JLabel lPressEnter;
    
    public PressEnter(int x, int y){
        gs = GraphicBuilder.getService();
        
        ImageIcon iPressStart = new ImageIcon(getClass().getResource("/resources/images/pressEnter.png"));
        
        lPressEnter = gs.getLabel(iPressStart, 0, 0);
        add(lPressEnter);
        
        setBackground(null);
        setLayout(null);
        setLocation(x, y);
        setSize(800, 400);
    }

    @Override
    public void update() {
    }
    
}
