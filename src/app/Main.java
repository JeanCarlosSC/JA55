package app;

import app.master.Sound;
import app.master.Window;
import services.systemService.SystemKeyboard;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Main{
    
    private SystemKeyboard keyboard;//ref
    
    private Window window;
    private Sound sound;
    
    public static void main (String args[]){
        Main main = new Main();
    }
    
    public Main(){
        keyboard = SystemKeyboard.getService();
        
        window = new Window(this);
        window.addKeyListener(keyboard);
        window.setRoom("main");
        
        sound = new Sound();
        sound.play("main");
        
        while(true){
            long lastTime = System.nanoTime();
            final double nsCode = 1000000000.0 / 60.0;
            double delta = 0;

            while(true){
                long now = System.nanoTime();
                delta += (now - lastTime) / nsCode;
                lastTime = now;

                while(delta >= 1.0){
                    run();
                    delta--;
                }
            } 
        }
    }
    
    private void run(){
        if(keyboard.get("escape")){
            System.exit(0);
        }
        if(keyboard.get("enter") && window.getTitleCurrentRoom().equals("main")){
            window.setRoom("psychedelicForest");
        }
        window.run();
    }
}
