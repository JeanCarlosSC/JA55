package control.client;

import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import view.ClientFrame;

public class Client {
    
    // class field
    private static int lastID = 0; // for define every client id
    private static final String RED_ADDRESS = "192.168.0";
    
    // object field
    private final int CONEXION_PORT = 5000;
    private Socket client;
    private String host = "localhost";
    private DataOutputStream output;
    private String name;
    
    private ClientFrame view;
    private String ip; // allows client to be recognized
    
    public Client() {
        ip = getUnusedIP();
        view = new ClientFrame(this);
        
        try {
            name = JOptionPane.showInputDialog("Ingrese su nombre");
            view.setTitle(name + "'s chat");
            client = new Socket(host, CONEXION_PORT);
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            output.writeUTF(name);
            ClientThread thread = new ClientThread(client, this);
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void eventOutput(ActionEvent event) {
        try {
            output = new DataOutputStream(client.getOutputStream());
            output.writeUTF(name + ":" + tfChat.getText());
            tfChat.setText("");
        } catch (Exception e) {
        }
    }
    
    public void updateList(DefaultListModel model) {
        this.list.setModel(model);
    }
    
    public void sendMessage(String message) {
        view.printMessage(" " + message);
    }
    
    //class method
    private static String getUnusedIP() {
        int unusedPort = lastID + 1;
        String unusedIP = RED_ADDRESS + unusedPort;
        return unusedIP;
    }
    
    public String getName() {
        return name;
    }
}
