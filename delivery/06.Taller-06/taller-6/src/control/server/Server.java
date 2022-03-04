package control.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import view.ServerFrame;

public class Server {
    
    // object field
    private ServerSocket server = null;
    private int port;
    private ServerFrame view;
    
    public Server(int port) {
        this.port = port;
    }
    
    public boolean init() {
        view = new ServerFrame(this);
        
        if (!initPort()) {
            return false;
        }
        
        while(true) {
            try {
                Socket client = server.accept();
                view.printMessage("Client connected from address: " + client.getInetAddress().getHostAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());

                ServerThread thread = new ServerThread(client, in.readUTF(), this);
                thread.start();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    private boolean initPort() {
        try {
            server = new ServerSocket(port);
        }
        catch (IOException exc) {
            view.printMessage("Could not start server on port: " + port);
            return false;
        }
        view.printMessage("The server is active and is listening at port: " + port);
        return true;
    }

    void printMessage(String message) {
        view.printMessage(message);
    }

}
