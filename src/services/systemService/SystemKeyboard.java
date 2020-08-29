package services.systemService;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Jean Carlos Santoya Cabrera jeancarlosodi@gmail.com
 */
public class SystemKeyboard extends KeyAdapter{
    private boolean escape, enter;
    
    private static SystemKeyboard service;
    
    private SystemKeyboard(){
        addKeyListener(this);
    }
    
    public boolean get(String button){
        if(button.equals("escape"))
            return escape;
        if(button.equals("enter"))
            return enter;
        return false;
    }
    
    public static SystemKeyboard getService(){
        if(service == null)
            service = new SystemKeyboard();
        return service;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            escape = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            enter = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            escape = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            enter = false;
        }
    }
}
