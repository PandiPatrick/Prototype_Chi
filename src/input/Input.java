package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private boolean[] pressed;

    public Input() {
        pressed = new boolean[255];
    }

    // Returns true or false if the Key is pressed
    public boolean isPressed(int keyCode) {
        return pressed[keyCode];
    }

    //region KeyListener abstract method area

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
    }

    //endregion
}
