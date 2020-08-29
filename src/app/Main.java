package app;


import app.characters.Player;
import app.master.Sound;
import app.master.Window;



/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Main{
    private Window window;
    private Sound sound;
    
    public static void main (String args[]){
        Main main = new Main();
    }
    
    public Main(){
        window = new Window(this);
        sound = new Sound();
        
        window.drawMain();
        sound.playMain();
        
        run();
    }
    
    public void nextRoom(){
        
    }
    
    private void run(){/*
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER && windowMachine.getRoom().equals("main")){
            windowMachine.setRoom("psychedelicForest");
            player = new Player(32, 32);
            windowMachine.addPlayer(player);
        }*/
    }
}
