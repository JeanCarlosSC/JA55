package app;


import app.characters.Player;
import app.master.Sound;
import app.master.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Main implements KeyListener{
    private Window windowMachine;
    private Sound soundMachine;
    private Player player;
    
    public static void main (String args[]){
        Main main = new Main();
    }
    
    public Main(){
        windowMachine = new Window(this);
        soundMachine = new Sound();
        
        windowMachine.drawMain();
        soundMachine.playMain();
        
        run();
    }
    
    public void nextRoom(){
        
    }
    
    private void run(){
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER && windowMachine.getRoom().equals("main")){
            windowMachine.setRoom("psychedelicForest");
            player = new Player(32, 32);
            windowMachine.addPlayer(player);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
