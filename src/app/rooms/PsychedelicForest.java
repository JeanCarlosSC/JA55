package app.rooms;

import app.tiles.Floor;
import java.awt.Color;
import services.gameService.GameRoom;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class PsychedelicForest extends GameRoom{
    
    public PsychedelicForest(int x, int y) {
        super(x, y, 1280, 720, "psychedelicForest");
        
        addTiles(0, 0, 12, 20, new Floor(0, 0));
        
        setBackground(Color.BLACK);
    }
    
}
