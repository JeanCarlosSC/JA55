package app.rooms;

import app.Room;
import java.awt.Color;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class PsychedelicForest extends Room{
    
    public PsychedelicForest(int x, int y) {
        super(x, y, 1280, 720, "psychedelicForest");
        
        addTiles(0, 0, 12, 20, "lawn");
        setBackground(Color.BLACK);
    }
    
}
