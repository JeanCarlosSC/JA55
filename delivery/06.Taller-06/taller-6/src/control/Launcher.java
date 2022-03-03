package control;

/**
 *
 * @author Jean Carlos Santoya Cabrera
 */
public class Launcher {
    public static void main(String[] args) {
        // Create a main server and instance the app controller
        Server mainServer = new Server();
        new Controller(mainServer);
    }
}
