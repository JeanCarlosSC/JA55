package control;

import control.server.Server;

public class Controller {
    
    private final int DEFAULT_PORT = 5000;
    private Server mainServer;
    
    public Controller() {
        // launch main server in default port
        mainServer = new Server(DEFAULT_PORT);
        mainServer.init();
    }
}
