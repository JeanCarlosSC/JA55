package services.gameService;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class GameSystem {
    private static GameSystem service;
    
    private GameSystem(){
    }
    
    public static GameSystem getService(){
        if(service == null)
            service = new GameSystem();
        return service;
    }
    
}
