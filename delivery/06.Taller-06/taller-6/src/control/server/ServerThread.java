package control.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import javax.swing.DefaultListModel;

public class ServerThread extends Thread {
    private DataInputStream input;
    private DataOutputStream output;
    private Server server;
    private Socket clientSocket;
    public static Vector<ServerThread> activeUsers = new Vector();
    private String name;
    private ObjectOutputStream objectOutput;
    
    public ServerThread(Socket clientSocket, String name, Server server) throws Exception {
        this.clientSocket = clientSocket;
        this.server = server;
        this.name = name;
        activeUsers.add(this);
        
        for (int i=0; i<activeUsers.size(); i++) {
            activeUsers.get(i).printMessage(name + " se ha conectado");
        }
    }
    
    public void run() {
        String message = " ";
        while (true) {            
            try {
                input = new DataInputStream(clientSocket.getInputStream());
                message = input.readUTF();
                
                for (int i = 0; i < activeUsers.size(); i++) {
                    activeUsers.get(i).printMessage(message);
                    server.printMessage("Message sent");
                }
            } catch (Exception e) {
                break;
            }
            
            activeUsers.removeElement(this);
            server.printMessage("Un usuario se ha desconectado");
            
            try {
                clientSocket.close();
            } catch (Exception e) {  }
        }
    }
    
    private void printMessage(String message) throws Exception {
        output = new DataOutputStream(clientSocket.getOutputStream());
        output.writeUTF(message);
        DefaultListModel model = new DefaultListModel();
        
        for (int i = 0; i < activeUsers.size(); i++) {
            model.addElement(activeUsers.get(i).name);
        }
        objectOutput = new ObjectOutputStream(clientSocket.getOutputStream());
        objectOutput.writeObject(model);
    }
}
