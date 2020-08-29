package app.tiles;

import services.gameService.GameTile;


/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Floor extends GameTile{
    
    public Floor(int x, int y) {
        super(x, y, "/resources/tiles/floor.png", 32, 32, "floor");
    }
    
}
