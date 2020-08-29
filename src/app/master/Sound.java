package app.master;

import static java.applet.Applet.newAudioClip;
import java.applet.AudioClip;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class Sound {
    
    private AudioClip main;
    
    public Sound(){
        main = newAudioClip(getClass().getResource("/resources/sounds/main.wav"));
    }
    
    public void play(String soundName){
        switch(soundName){
            case "main":
                main.play();
                break;
        }
    }
    
}
