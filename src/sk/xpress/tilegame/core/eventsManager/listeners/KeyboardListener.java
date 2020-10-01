package sk.xpress.tilegame.core.eventsManager.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w': {
                System.out.println("DOPREDU");
                break;
            }
            case 'a': {
                System.out.println("DOLAVA");
                break;
            }
            case 's': {
                System.out.println("DOZADU");
                break;
            }
            case 'd': {
                System.out.println("DOPRAVA");
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
