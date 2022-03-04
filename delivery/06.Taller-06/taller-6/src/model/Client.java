package model;

public class Client {
    
    // class field
    private static int lastID = 0; // for define every client id
    
    // object field
    private String ip; // allows client to be recognized
    
    private Client() {
        ip = getUnusedIP();
    }
    
    //class method
    private static String getUnusedIP() {
        int unusedPort = lastID + 1;
        String unusedIP = Server.IP + "." + unusedPort;
        return unusedIP;
    }
    
    public static void launchNewClient() {
        
    }
    
}
