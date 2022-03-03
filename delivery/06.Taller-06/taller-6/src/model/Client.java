package model;

public class Client {
    
    // class field
    private static String lastIP = "192.168.0.0"; // for define every client id
    
    // object field
    private String ip; // allows client to be recognized
    
    public Client() {
        ip = getUnusedIP();
    }
    
    //class method
    private static String getUnusedIP() {
        int unusedPort = Integer.parseInt(lastIP.substring(10))+1;
        String unusedIP = "192.168.0." + unusedPort;
        return unusedIP;
    }
    
}
