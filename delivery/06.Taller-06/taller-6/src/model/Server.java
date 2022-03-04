package model;

import java.net.ServerSocket;
import java.util.ArrayList;
import view.ServerFrame;

public class Server {
    
    // class field
    
    // object field
    private int port;
    private ServerFrame view;
    
    public Server(int port) {
        this.port = port;
    }
    
    public void conectarCliente(Client client) {
        
    }
    
    public void run() {
        view = new ServerFrame(this);
        view.printMessage("The server is running in the port " + port + ".");
    }
    
}
