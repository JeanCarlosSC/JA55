package app.tiles;

import app.master.Tile;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Floor extends Tile{
    
    
    public Floor(int x, int y) {
        super(x, y, "/resources/tiles/floor.png", 32, 32, "floor");
    }
    
}
