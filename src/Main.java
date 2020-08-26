
import app.Sound;
import app.Window;



/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Main {
    Window windowMachine;
    Sound soundMachine;
    
    public static void main (String args[]){
        Main main = new Main();
    }
    
    public Main(){
        windowMachine = new Window();
        soundMachine = new Sound();
        
        windowMachine.drawMain();
        soundMachine.playMain();
        
        run();
    }
    
    public void nextRoom(){
        
    }
    
    private void run(){
        
    }
}
