package utilities;

import java.awt.Component;
import java.awt.event.KeyEvent;

/**
 *
 * @author NESAS
 */

public class Input{
    public static final int ENTER = KeyEvent.VK_ENTER;
    public static final int DOWN = KeyEvent.VK_ENTER;
    public static final int UP = KeyEvent.VK_ENTER;
    public static final int LEFT = KeyEvent.VK_ENTER;
    public static final int RIGHT = KeyEvent.VK_ENTER;
    
    public static void moveCursor(KeyEvent e, Component c, int key){
        if(e.getKeyCode() == key){
            c.requestFocus();
        }
    }
    
    public static void moveCursor(KeyEvent e, Component c, int[] keys){
        for(int key : keys){
            if(e.getKeyCode() == key){
                c.requestFocus();
            }
        }
    }
    
    public static void executeAction(KeyEvent e, int key, Action a){
        if(e.getKeyCode() == key){
            a.method();
        }
    }
    
    public static void executeButtonClick(KeyEvent e, Component button, int key, Action a){
        if(button.getBackground() == Colors.HOVER_COLOR){
            executeAction(e, key, a);
        }
    }
    
    public static void moveCursorWithAction(KeyEvent e, Component c, int[] keys){
        for(int key : keys){
            if(e.getKeyCode() == key){
                c.requestFocus();
            }
        }
    }
}
